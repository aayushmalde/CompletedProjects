//Aayush Malde, asm7yaq, 10/8/2020, AVLNode.h

#ifndef AVLNODE_H
#define AVLNODE_H
#include <string>
using namespace std;

class AVLNode {
    AVLNode();
    ~AVLNode();

    string value;
    AVLNode* left;
    AVLNode* right;
    int height;

    friend class AVLTree;
};

#endif
