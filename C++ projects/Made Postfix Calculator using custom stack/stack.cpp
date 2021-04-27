//Aayush Malde, asm7yaq, 9/23/2020, stack.cpp

#include "stack.h"
#include "stacknode.h"
#include <iostream>
#include <string>
#include <cstdlib>
using namespace std;

Stack::Stack(){
  head=NULL;
  count=0;
}

Stack::~Stack(){
  while(count>0){
    pop();
  }
  delete head;
}

bool Stack::isEmpty() const{
  if(count>0){
    return false;
  }
  return true;
}

void Stack::push(int value){
  StackNode *temp = new StackNode();
  temp->value=value;
  temp->next=head;
  head=temp;
  count++;
}

void Stack::pop(){
  if(isEmpty()==false){
  head=head->next;
  count--;
  }
  else{
  exit(-1);
  }
}

int Stack::top() const{
  if(isEmpty()==true){
    exit(-1);
  }
  return head->value;
}


