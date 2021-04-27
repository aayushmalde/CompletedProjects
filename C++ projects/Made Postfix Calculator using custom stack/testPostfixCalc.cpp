//Aayush Malde, asm7yaq, 9/24/2020, testPostfixCalculator.cpp

#include "stacknode.h"
#include "stack.h"
#include "postfixCalculator.h"
#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

int main(){
  postfixCalculator num;
string token;
while (cin >> token) {
    // Do stuff with `token`!
    // For example, we can print each token back out on its own line:
  if(token=="+"){
    num.addition();
  }
  else if(token=="-"){
    num.subtraction();
  }
  else if(token=="*"){
    num.multiplication();
  }
  else if(token=="/"){
    num.division();
  }
  else if(token=="~"){
    num.negation();
  }
  else{
    int x = stoi(token);
    num.push(x);
  }
}
 cout << num.top() << endl;
 return 0;
}


