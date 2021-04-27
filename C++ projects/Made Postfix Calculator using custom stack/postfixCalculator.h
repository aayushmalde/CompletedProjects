//Aayush Malde, asm7yaq, 9/24/2020, postfixCalculator.h

#ifndef POSTFIXCALCULATOR_H
#define POSTFIXCALCULATOR_H

#include <iostream>
#include <string>
#include "stacknode.h"
#include "stack.h"
#include <cstdlib>
using namespace std;

class postfixCalculator{
 public:
  postfixCalculator();
  void addition();
  void subtraction();
  void multiplication();
  void division();
  void negation();
  Stack num = Stack();
  int top();
  void push(int e);
};

#endif
