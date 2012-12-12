# Makefile for the Towers of Hanoi problem
JFLAGS=-g -d bin
JRUN=-classpath bin/

SOURCES=$(wildcard src/*.java)
OBJECTS=$(patsubst src/%.java,bin/%.class,$(SOURCES))

MAIN=hello

all: build

run:
	java $(JRUN) $(MAIN)

build:
	@mkdir -p bin
	javac $(JFLAGS) $(SOURCES)

clean:
	rm -rf bin $(OBJECTS)