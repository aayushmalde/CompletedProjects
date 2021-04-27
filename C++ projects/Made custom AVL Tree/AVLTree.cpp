//Aayush Malde, asm7yaq, 10/8/2020, AVLTree.cpp

#include "AVLNode.h"
#include "AVLTree.h"
#include <iostream>
#include <string>
using namespace std;

AVLTree::AVLTree() {
    root = NULL;
}

AVLTree::~AVLTree() {
    delete root;
    root = NULL;
}

// insert finds a position for x in the tree and places it there, rebalancing
// as necessary.
void AVLTree::insert(const string& x) {
    // YOUR IMPLEMENTATION GOES HERE
  insert(root,x);
}

void AVLTree::insert(AVLNode*& n, const string& x){
  if(n==NULL){
    n = new AVLNode();
    n->value=x;
  }
  else if(x<n->value){
    insert(n->left,x);
    // Recalculate heights and balance this subtree
    n->height = 1 + max(height(n->left), height(n->right));
  balance(n);
  }
  else if(x>n->value){
    insert(n->right,x);
    // Recalculate heights and balance this subtree
    n->height = 1 + max(height(n->left), height(n->right));
  balance(n);
  }
}

// remove finds x's position in the tree and removes it, rebalancing as
// necessary.
void AVLTree::remove(const string& x) {
    root = remove(root, x);
}

// pathTo finds x in the tree and returns a string representing the path it
// took to get there.
string AVLTree::pathTo(const string& x) const {
    // YOUR IMPLEMENTATION GOES HERE
  if(find(x)==true){
    return pathTo(root,x);
  }
  else{
    return "";
  }
}

string AVLTree::pathTo(AVLNode* n, const string& x) const{
  if(n->value==x){
    return n->value;
  }
  else if(x<n->value){
    return n->value+" "+pathTo(n->left,x);
  }
  else if(x>n->value){
    return n->value+" "+pathTo(n->right,x);
  }
  else{
    return "";
  }
}

// find determines whether or not x exists in the tree.
bool AVLTree::find(const string& x) const {
    // YOUR IMPLEMENTATION GOES HERE
  AVLNode* n = find(root,x);
  if(n==NULL){
    return false;
  }
  else{
    return true;
  }
}

AVLNode* AVLTree::find(AVLNode* n, const string& x) const{
  if(n==NULL){
    return NULL;
  }
  else if(x<n->value){
    return find(n->left,x);
  }
  else if(x>n->value){
    return find(n->right,x);
  }
  else{
    return n;
  }
}

// numNodes returns the total number of nodes in the tree.
int AVLTree::numNodes() const {
    // YOUR IMPLEMENTATION GOES HERE
  return numNodes(root);
}

int AVLTree::numNodes(AVLNode *n) const{
  if(n==NULL){
    return 0;
  }
  else{
    return numNodes(n->left)+numNodes(n->right)+1;
  }
}

// balance makes sure that the subtree with root n maintains the AVL tree
// property, namely that the balance factor of n is either -1, 0, or 1.
void AVLTree::balance(AVLNode*& n) {
    // YOUR IMPLEMENTATION GOES HERE
  if(height(n->right)-height(n->left)==2){
    if(height(n->right->right)-height(n->right->left)<0){
      n->right=rotateRight(n->right);
    }
    n=rotateLeft(n);
  }
  else if(height(n->right)-height(n->left)==-2){
    if(height(n->left->right)-height(n->left->left)>0){
      n->left=rotateLeft(n->left);
    }
    n=rotateRight(n);
  }
}

// rotateLeft performs a single rotation on node n with its right child.
AVLNode* AVLTree::rotateLeft(AVLNode*& n) {
    // YOUR IMPLEMENTATION GOES HERE
  AVLNode* newroot= n->right;
  n->right=newroot->left;
  newroot->left=n;
  // Recalculate heights
  n->height = 1 + max(height(n->left), height(n->right));
  newroot->height = 1 + max(height(newroot->left), height(newroot->right));
  //set root to newroot
  return newroot;
}


// rotateRight performs a single rotation on node n with its left child.
AVLNode* AVLTree::rotateRight(AVLNode*& n) {
    // YOUR IMPLEMENTATION GOES HERE
  AVLNode* newroot= n->left;
  n->left=newroot->right;
  newroot->right=n;
  // Recalculate heights
  n->height = 1 + max(height(n->left), height(n->right));
  newroot->height = 1 + max(height(newroot->left), height(newroot->right));
  //set root to newroot
  return newroot;
}

// private helper for remove to allow recursion over different nodes.
// Returns an AVLNode* that is assigned to the original node.
AVLNode* AVLTree::remove(AVLNode*& n, const string& x) {
    if (n == NULL) {
        return NULL;
    }

    // first look for x
    if (x == n->value) {
        // found
        if (n->left == NULL && n->right == NULL) {
            // no children
            delete n;
            n = NULL;
            return NULL;
        } else if (n->left == NULL) {
            // Single child (left)
            AVLNode* temp = n->right;
            n->right = NULL;
            delete n;
            n = NULL;
            return temp;
        } else if (n->right == NULL) {
            // Single child (right)
            AVLNode* temp = n->left;
            n->left = NULL;
            delete n;
            n = NULL;
            return temp;
        } else {
            // two children -- tree may become unbalanced after deleting n
            string sr = min(n->right);
            n->value = sr;
            n->right = remove(n->right, sr);
        }
    } else if (x < n->value) {
        n->left = remove(n->left, x);
    } else {
        n->right = remove(n->right, x);
    }

    // Recalculate heights and balance this subtree
    n->height = 1 + max(height(n->left), height(n->right));
    balance(n);

    return n;
}

// min finds the string with the smallest value in a subtree.
string AVLTree::min(AVLNode* node) const {
    // go to bottom-left node
    if (node->left == NULL) {
        return node->value;
    }
    return min(node->left);
}

// height returns the value of the height field in a node.
// If the node is null, it returns -1.
int AVLTree::height(AVLNode* node) const {
    if (node == NULL) {
        return -1;
    }
    return node->height;
}

// max returns the greater of two integers.
int max(int a, int b) {
    if (a > b) {
        return a;
    }
    return b;
}

// Helper function to print branches of the binary tree
// You do not need to know how this function works.
void showTrunks(Trunk* p) {
    if (p == NULL) return;
    showTrunks(p->prev);
    cout << p->str;
}

// Recursive function to print binary tree
// It uses inorder traversal
void AVLTree::printTree(AVLNode* root, Trunk* prev, bool isRight) {
    if (root == NULL) return;

    string prev_str = "    ";
    Trunk* trunk = new Trunk(prev, prev_str);

    printTree(root->right, trunk, true);

    if (!prev)
        trunk->str = "---";
    else if (isRight) {
        trunk->str = ".---";
        prev_str = "   |";
    } else {
        trunk->str = "`---";
        prev->str = prev_str;
    }

    showTrunks(trunk);
    cout << root->value << endl;

    if (prev) prev->str = prev_str;
    trunk->str = "   |";

    printTree(root->left, trunk, false);

    delete trunk;
}

void AVLTree::printTree() {
    printTree(root, NULL, false);
}
