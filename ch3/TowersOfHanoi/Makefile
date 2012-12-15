# Makefile for the Towers of Hanoi

SOURCEPATH=src
CLASSPATH=bin
DOCPATH=doc
MAINPATH=main
TESTPATH=tests

MAIN=NULL
MANIFEST=$(SOURCEPATH)/manifest.txt

MAINFILES=$(shell find $(SOURCEPATH)/$(MAINPATH) -name *.java)
TESTFILES=$(shell find $(SOURCEPATH)/$(TESTPATH) -name *.java)

JCOMPFLAGS=-g -classpath $(CLASSPATH) -d $(CLASSPATH)
JTESTFLAGS=-g -classpath $(CLASSPATH) -d $(CLASSPATH)
JRUNFLAGS=-classpath $(CLASSPATH)
JARFLAGS=cvfm $(CLASSPATH)/$(MAIN).jar $(MANIFEST)
DOCFLAGS=-classpath $(CLASSPATH) -d $(DOCPATH)

all: build

build:
	@mkdir -p $(CLASSPATH)/$(MAINPATH)
	javac $(JCOMPFLAGS) $(MAINFILES)

run:
	java $(JRUNFLAGS) $(MAIN)

doc:
	@mkdir -p $(DOCPATH)
	javadoc $(DOCFLAGS) $(MAINFILES)

tests: build
	@mkdir -p $(CLASSPATH)/$(TESTPATH)
	javac $(JTESTFLAGS) $(TESTFILES)

jar: build
	jar $(JARFLAGS) $(CLASSPATH)/*.class

clean:
	rm -rf $(CLASSPATH) $(DOCPATH)