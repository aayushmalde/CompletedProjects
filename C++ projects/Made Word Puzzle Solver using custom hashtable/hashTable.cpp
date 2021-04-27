//Aayush Malde, asm7yaq, 10/12/2020, hashTable.cpp

#include <iostream>
#include <string>
#include <list>
#include <vector>
#include <cmath>
#include "hashTable.h"

using namespace std;

hashTable::hashTable(int size){
  //declare vector of size size
  
  table.resize(size+1);
  this->tablesize=size;

  powers.resize(22);
  for(int i=0;i<22;i++){
    powers[i]=pow(41,i);
  }

}

void hashTable::insert(string value){
  //ASK TA- table.size() or tablesize isnt defined
  int index=hash(value)&this->tablesize;
  table[index].push_back(value);
}

bool hashTable::find(string value){
  int index=hash(value)&this->tablesize;
  list<string> &temp=table[index];
  //reference cplusplusvectors
  for(list<string>::iterator itr = temp.begin();itr !=temp.end();++itr){
    if(value.compare(*itr)==0){
      return true;
    }
  }
  return false;
}

unsigned int hashTable::hash(string x){
  unsigned int index = 0;
  for(int i=0;i<x.length();i++){
    index=index+powers[i]*(int)x[i];
  }
  return index;
}
