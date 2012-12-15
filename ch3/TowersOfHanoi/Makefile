# Makefile for the Towers of Hanoi

# Command line tools to use
JC=javac
JDOC=javadoc
JARJAR=jar

# Desired file paths
SOURCEPATH=src
CLASSPATH=bin
DOCPATH=doc

# Path to main and 
MAINPATH=main
TESTPATH=tests

# Name of main function
MAINNAME=HanoiSolver
MANIFEST=$(SOURCEPATH)/manifest.txt

# Files that will need to be updated. Note normal files separated from test files.
MAINFILES=$(shell find $(SOURCEPATH)/$(MAINPATH) -name *.java)
MAINCLASSFILES=$(patsubst $(SOURCEPATH)/%.java, $(CLASSPATH)/%.class, $(MAINFILES))
TESTFILES=$(shell find $(SOURCEPATH)/$(TESTPATH) -name *.java)
TESTCLASSFILES=$(patsubst $(SOURCEPATH)/%.java, $(CLASSPATH)/%.class, $(TESTFILES))
ALLCLASSFILES=$(MAINCLASSFILES) $(TESTCLASSFILES)

# Flags for command line tools
JFLAGS=-g -sourcepath $(SOURCEPATH) -classpath $(CLASSPATH) -d $(CLASSPATH)
JRUNFLAGS=-classpath $(CLASSPATH)
JARFLAGS=cf $(MAINNAME).jar -C $(CLASSPATH)
DOCFLAGS=-classpath $(CLASSPATH) -sourcepath $(SOURCEPATH) -d $(DOCPATH)

# Files named clean are stupid
.PHONY: clean

all: main

main: folders $(MAINCLASSFILES)

tests: main $(TESTCLASSFILES)

# All class files in bin depend on their corresponding files in src
$(ALLCLASSFILES): $(CLASSPATH)%.class: $(SOURCEPATH)%.java
	$(JC) $(JFLAGS) $<

doc:
	@mkdir -p $(DOCPATH)
	javadoc $(DOCFLAGS) $(MAINFILES)

jar: main
	$(JARJAR) $(JARFLAGS) $(MAINPATH)

run: main
	java $(JRUNFLAGS) $(MAINPATH)/$(MAINNAME)

folders: 
	@mkdir -p $(CLASSPATH)/$(MAINPATH) $(CLASSPATH)/$(TESTPATH)

clean:
	rm -rf $(CLASSPATH) $(DOCPATH) *.jar