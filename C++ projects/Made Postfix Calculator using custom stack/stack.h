//Aayush Malde, asm7yaq, 9/24/2020, stack.h

#ifndef STACK_H
#define STACK_H

#include <iostream>
#include <string>
#include "stacknode.h"
#include <cstdlib>
using namespace std;

class Stack{
 public:
  Stack();
  ~Stack();
  bool isEmpty() const;
  void push(int value);
  void pop();
  int top() const;

 private:
  StackNode *head;
  int count;
};
#endif
