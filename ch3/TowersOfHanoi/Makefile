# Makefile for the Towers of Hanoi

SOURCEPATH=src
BUILDPATH=bin
DOCPATH=doc

SOURCES=$(wildcard $(SOURCEPATH)/*.java)
OBJECTS=$(patsubst $(SOURCEPATH)/%.java,$(BUILDPATH)/%.class,$(SOURCES))

JCOMPFLAGS=-g -classpath $(SOURCEPATH)/ -d $(BUILDPATH)/
JRUNFLAGS=-classpath $(BUILDPATH)/
DOCFLAGS=-classpath $(SOURCEPATH)/ -d $(DOCPATH)/

MAIN=NULL

all: build

run:
	java $(JRUNFLAGS) $(MAIN)

doc:
	@mkdir -p $(DOCPATH)
	javadoc $(DOCFLAGS) $(SOURCES)

build:
	@mkdir -p $(BUILDPATH)
	javac $(JCOMPFLAGS) $(SOURCES)

clean:
	rm -rf $(BUILDPATH) $(DOCPATH) $(OBJECTS)