//Aayush Malde, asm7yaq, 10/12/2020, wordPuzzle.cpp

#include <iostream>
#include <fstream>
#include <string>
#include "hashTable.h"
#include "timer.h"
using namespace std;

// We create a 2-D array of some big size, and assume that the grid
// read in will be less than this size (a valid assumption for lab 6)
#define MAXROWS 500
#define MAXCOLS 500
char grid[MAXROWS][MAXCOLS];
hashTable *h;

// Forward declarations
bool readInGrid(string filename, int& rows, int& cols);
string getWordInGrid(int startRow, int startCol, int dir, int len,
                     int numRows, int numCols);
void readInDictionary(string filename);
bool dictionarySize(string filename);
unsigned int dictionarysize=0;
bool checkprime(unsigned int p);
int getNextPrime(unsigned int n);
vector<string> printvector;

int main (int argc, char* argv[]){
  for(int i=1;i<argc;i++){
    string s(argv[i]);
  }

  bool result = dictionarySize(argv[1]);
  if (!result) {
        cout << "Error reading in file!" << endl;
        return 1;
    }
    dictionarysize=dictionarysize*5;
  result=checkprime(dictionarysize);
  if(result==false){
    int x=getNextPrime(dictionarysize);
    dictionarysize=x;
  }
  h = new hashTable(dictionarysize);
  result=true;
  readInDictionary(argv[1]);
  if (!result) {
        cout << "Error reading in file!" << endl;
        return 1;
    }


  // to hold the number of rows and cols in the input file
    int rows, cols;

    // attempt to read in the file
    result = readInGrid(argv[2], rows, cols);
    // if there is an error, report it
    if (!result) {
        cout << "Error reading in file!" << endl;
        return 1;
    }
    
    timer t;
    t.start();

    int numwordsfound=0;

    //because the corner is still checking directions not in the grid, you
    //can optimize further by checking the bounds
    //You can also optimize by having the length go up till the end of the grid
    
    //for every row
    for(int i=0;i<rows;i++){
      //for every column
      for(int j=0;j<cols;j++){
	//for every direction
	for(int k=0;k<8;k++){
	  //for every length
	  for(int l=3;l<=22;l++){
	    string temp=getWordInGrid(i,j,k,l,rows,cols);
	    if(l==temp.length()&&h->find(temp)){
		numwordsfound++;
	      //output depends on direction
	      if(k==0){
		printvector.push_back("N ("+to_string(i)+", "+to_string(j)+"):    "+temp);
	      }
	      else if(k==1){
		printvector.push_back("NE ("+to_string(i)+", "+to_string(j)+"):    "+temp);
	      }
	      else if(k==2){
		printvector.push_back("E ("+to_string(i)+", "+to_string(j)+"):    "+temp);
	      }
	      else if(k==3){
		printvector.push_back("SE ("+to_string(i)+", "+to_string(j)+"):    "+temp);
	      }
	      else if(k==4){
		printvector.push_back("S ("+to_string(i)+", "+to_string(j)+"):    "+temp);
	      }
	      else if(k==5){
		printvector.push_back("SW ("+to_string(i)+", "+to_string(j)+"):    "+temp);
	      }
	      else if(k==6){
		printvector.push_back("W ("+to_string(i)+", "+to_string(j)+"):    "+temp);
	      }
	      else if(k==7){
		printvector.push_back("NW ("+to_string(i)+", "+to_string(j)+"):    "+temp);
	      }
	    }
	  }
	}			
      }
    }

    for(int i=0;i<printvector.size();i++){
        cout<<printvector[i]<<endl;
    }
    cout<<numwordsfound<<" words found"<<endl;

    
    t.stop();
    cout<< "Time took was "<<t.getTime() <<" seconds"<<endl;
    
    return 0;
  
}

// yes, there are much faster -- and much better -- ways to check if a
// number is prime (see the Sieve of Eratosthenes, for one example),
// but this code will work correctly, it is fairly straightforward,
// and it is fast enough for our purposes in the hash lab
bool checkprime(unsigned int p) {
    if ( p <= 1 ) // 0 and 1 are not primes; the are both special cases
        return false;
    if ( p == 2 ) // 2 is prime
        return true;
    if ( p % 2 == 0 ) // even numbers other than 2 are not prime
        return false;
    for ( int i = 3; i*i <= p; i += 2 ) // only go up to the sqrt of p
        if ( p % i == 0 )
            return false;
    return true;
}

int getNextPrime (unsigned int n) {
    while ( !checkprime(++n) );
    return n; // all your primes are belong to us
}

bool dictionarySize(string filename) {
    // try to open the file
    ifstream file(filename);
    // upon an error, return false
    if (!file.is_open()) {
        return false;
    }

    // read the dictionary
    string data;
    while(file >> data){
      dictionarysize++;
    }

    // close the file
    file.close();

    
    return true;
}

void readInDictionary(string filename) {
    // try to open the file
    ifstream file(filename);

    // read the dictionary
    string data;
    while(file >> data){
        h->insert(data);
    }

    // close the file
    file.close();
}

/** This function will read in a grid file, as per the format in the
 * CS 2150 lab 6 document, into a global grid[][] array.  It uses C++
 * file streams, and thus requires the the <fstream> #include header.
 *
 * @return true or false, depending on whether the file was
 *         successfully opened.
 * @param filename The file name to read in -- it's assumed to be in
 *                 the file format described in the lab document.
 * @param rows The number of rows as specified in the input file;
 *             as this is a reference, it is set by the function.
 * @param cols The number of columns as specified in the input file;
 *             as this is a reference, it is set by the function.
 */
bool readInGrid(string filename, int& rows, int& cols) {
    // try to open the file
    ifstream file(filename);
    // upon an error, return false
    if (!file.is_open()) {
        return false;
    }

    // first comes the number of rows
    file >> rows;
    //cout << "There are " << rows << " rows." << endl;

    // then the columns
    file >> cols;
    //cout << "There are " << cols << " cols." << endl;

    // and finally the grid itself
    string data;
    file >> data;

    // close the file
    file.close();

    // convert the string read in to the 2-D grid format into the
    // grid[][] array.
    // In the process, we'll print the grid to the screen as well.
    int pos = 0; // the current position in the input data
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            grid[r][c] = data[pos++];
            //cout << grid[r][c];
        }
        //cout << endl;
    }
    return true;
}

/** This function will retrieve a word in a grid of letters in a given
 * direction.  If the end of the grid is encountered before the length
 * of the desired string is reached, then a shorter string will be
 * returned.  The data is retrieved from a global char grid[][]
 * array, which is assumed to be defined (and in scope).  NOTE: The
 * return value is a static string variable (for efficiency
 * reasons), so a successive return value will overwrite a previous
 * return value.
 *
 * @return A STATIC string containing the letters in the provided direction.
 * @param startRow The starting (row,col) position to find the word.
 * @param startCol The starting (row,col) position to find the word.
 * @param dir The direction to move: 0 is north (upwards), 1 is
 *            northeast, and it rotates around clockwise until it
 *            reaches 7 for northwest.
 * @param len The desired length of the string to return (assuming
 *            the edge of the grid is not reached--if the edge of the
 *            grid is reached, it will return as many characters as
 *            possible up to the edge of the grid, so the returned
 *            string may not have the same length as this parameter
 *            indicates).
 * @param numRows The number of rows in the global char grid[][]
 *                array.
 * @param numCols The number of columns in the global char grid[][]
 *                array.
 */
string getWordInGrid (int startRow, int startCol, int dir, int len,
                      int numRows, int numCols) {
    // the static-ness of this variable prevents it from being
    // re-declared upon each function invocation.  It also prevents it
    // from being deallocated between invocations.  It's probably not
    // good programming practice, but it's an efficient means to return
    // a value.
    static string output;
    output.clear(); // Since it's static we need to clear it
    output.reserve(256); // Can't set capacity in the constructor so do it the first time here

    // the position in the output array, the current row, and the
    // current column
    int r = startRow, c = startCol;
    // iterate once for each character in the output
    for (int i = 0; i < len; i++) {
        // if the current row or column is out of bounds, then break
        if (c >= numCols || r >= numRows || r < 0 || c < 0) {
            break;
        }

        // set the next character in the output array to the next letter
        // in the grid
        output += grid[r][c];

        // move in the direction specified by the parameter
        switch (dir) { // assumes grid[0][0] is in the upper-left
            case 0:
                r--;
                break; // north
            case 1:
                r--;
                c++;
                break; // north-east
            case 2:
                c++;
                break; // east
            case 3:
                r++;
                c++;
                break; // south-east
            case 4:
                r++;
                break; // south
            case 5:
                r++;
                c--;
                break; // south-west
            case 6:
                c--;
                break; // west
            case 7:
                r--;
                c--;
                break; // north-west
        }
    }

    return output;
}

