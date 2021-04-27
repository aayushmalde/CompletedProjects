//Aayush Malde, asm7yaq, 9/24/2020, stacknode.h

#ifndef STACKNODE_H
#define STACKNODE_H
#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

class StackNode{
 public:
  StackNode();

 private:
  int value;
  StackNode *next;

friend class Stack;
};

#endif
