#!bin/bash

LIB		=	./lib/*.jar\

SRC		=   src/*.java\
			src/constraints/*.java\
			src/solvers/*.java\

TEST	=	src/test/*.java\

BIN	    =	bin\

javac:
	@(javac -d $(BIN) $(SRC) && echo "Compilation successful") || echo "Compilation failed"

main:
	@(java -cp $(BIN) Main && echo "Execution successful") || echo "Execution failed"

interactive:
	@(java -cp $(BIN) InteractiveScheduling && echo "Execution successful") || echo "Execution failed"