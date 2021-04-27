# Aayush Malde, asm7yaq, 10/5/2020, Makefile

CXX=clang++ $(CXXFLAGS)
CXXFLAGS=-Wall -O2# Enable all warnings
DEBUG=-g
OBJECTS = TreeCalc.o TreeCalcTest.o TreeNode.o

TreeCalc: $(OBJECTS)
	$(CXX) $(DEBUG) $(OBJECTS)

.PHONY: clean
clean:
	-rm -f *.o a.out

TreeCalc.o: TreeCalc.cpp TreeCalc.h TreeNode.h
TreeCalcTest.o: TreeCalcTest.cpp TreeCalc.h TreeNode.h
TreeNode.o: TreeNode.cpp TreeNode.h

