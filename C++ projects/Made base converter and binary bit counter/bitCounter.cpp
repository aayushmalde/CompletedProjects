//Aayush Malde, asm7yaq, 9/28/2020, bitCounter.cpp

#include <iostream>
#include <string>
#include <climits>
#include <math.h>

using namespace std;

int bitCounter(int n){
  if(n==0){
    return 0;
  }
  if(n%2==0){
    return bitCounter(n/2);
  }
  else{
    return 1+bitCounter(n/2);
  }
}

string baseConverter(string num,int stb,int endb){
  //convert from start base to base 10
  int decimal = 0;
  int ct=0;
  for(int i=num.length()-1;i>=0;i--){
    int converted = 0;
    char c = num[i];
    if(isdigit(c)){
      converted = c - 48;
    }
    else{
      converted = c - 55;
    }
    decimal=decimal+pow(stb,ct)*converted;
    ct++;
  }
  
  //convert base 10 to end base
  string temp;
  while(decimal>0){
    int rem=decimal%endb;
    char c=rem;
    if(rem<10){
    temp.insert(0,to_string(rem));
    }
    else{
      c=c+55;
      temp.insert(0,1,c);
    }
    decimal=decimal/endb;
  }
  return temp;
}

int main(int argc, char **argv){
  for(int i=1;i<argc;i++){
    string s(argv[i]);
  }

  int bitcount = stoi(argv[1]);
  int startbase = stoi(argv[3]);
  int endbase = stoi(argv[4]);

  int count = bitCounter(bitcount);
  cout<<bitcount<<" has "<<count<<" bit(s)"<<endl;
  string baseconverter = baseConverter(argv[2],startbase,endbase);
  cout<<argv[2]<< " (base "<<startbase<<") = "<< baseconverter<< " (base "<<endbase<<")"<<endl;
}
