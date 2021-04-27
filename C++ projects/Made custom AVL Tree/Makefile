# Aayush Malde, asm7yaq, 10/8/2020, Makefile

CXX=clang++ $(CXXFLAGS)
CXXFLAGS=-Wall -O2# Enable all warnings
DEBUG=-g
OBJECTS = AVLNode.o AVLTree.o AVLPathTest.o

AVLTree: $(OBJECTS)
	$(CXX) $(DEBUG) $(OBJECTS)

.PHONY: clean
clean:
	-rm -f *.o a.out

AVLNode.o: AVLNode.cpp AVLNode.h
AVLPathTest.o: AVLPathTest.cpp AVLTree.h AVLNode.h
AVLTree.o: AVLTree.cpp AVLNode.h AVLTree.h
