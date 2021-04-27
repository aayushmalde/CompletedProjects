# Aayush Malde, asm7yaq, 10/12/2020, Makefile

CXX=clang++ $(CXXFLAGS)
CXXFLAGS=-Wall -O2# Enable all warnings
DEBUG=-g
OBJECTS = wordPuzzle.o timer.o hashTable.o

wordPuzzle: $(OBJECTS)
	$(CXX) $(DEBUG) $(OBJECTS)

.PHONY: clean
clean:
	-rm -f *.o a.out

wordPuzzle.o: wordPuzzle.cpp hashTable.h timer.h
timer.o: timer.cpp timer.h
hashTable.o: hashTable.cpp hashTable.h

