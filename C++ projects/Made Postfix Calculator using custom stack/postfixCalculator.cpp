//Aayush Malde, asm7yaq, 9/24/2020, postfixCalculator.cpp

#include "stacknode.h"
#include "stack.h"
#include "postfixCalculator.h"
#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

postfixCalculator::postfixCalculator(){}

void postfixCalculator::addition(){
  int x =  num.top();
  num.pop();
  int y = num.top();
  num.pop();
  int z = y+x;
  num.push(z);
}

void postfixCalculator::subtraction(){
  int x = num.top();
  num.pop();
  int y = num.top();
  num.pop();
  int z = y-x;
  num.push(z);
}

void postfixCalculator::multiplication(){
  int x = num.top();
  num.pop();
  int y = num.top();
  num.pop();
  int z=y*x;
  num.push(z);
}

void postfixCalculator::division(){
  int x = num.top();
  num.pop();
  int y = num.top();
  num.pop();
  int z=y/x;
  num.push(z);
}
  
void postfixCalculator::negation(){
  int x = num.top();
  num.pop();
  x=x*-1;
  num.push(x);
}

int postfixCalculator::top(){
  return num.top();
}

void postfixCalculator::push(int e){
  num.push(e);
}



