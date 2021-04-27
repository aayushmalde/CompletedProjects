# Aayush Malde, asm7yaq, 10/6/2020, Makefile

CXX=clang++ $(CXXFLAGS)
CXXFLAGS=-Wall -O2# Enable all warnings
DEBUG=-g
OBJECTS = BinaryNode.o BinarySearchTree.o BSTPathTest.o

BinarySearchTree: $(OBJECTS)
	$(CXX) $(DEBUG) $(OBJECTS)

.PHONY: clean
clean:
	-rm -f *.o a.out

BinaryNode.o: BinaryNode.cpp BinaryNode.h
BinarySearchTree.o: BinarySearchTree.cpp BinaryNode.h BinarySearchTree.h
BSTPathTest.o: BSTPathTest.cpp BinarySearchTree.h BinaryNode.h
