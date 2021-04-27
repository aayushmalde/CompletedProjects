//Aayush Malde, asm7yaq, 10/12/2020, hashTable.h

#include <iostream>
#include <string>
#include <list>
#include <vector>
using namespace std;

#ifndef HASHTABLE_H
#define HASHTABLE_H

class hashTable{
 public:
  hashTable(int size);
  void insert(string value);
  bool find(string value);
  unsigned int hash(string x);

 private:
  vector<list<string>> table;
  int tablesize;
  vector<unsigned int> powers;
};

#endif
