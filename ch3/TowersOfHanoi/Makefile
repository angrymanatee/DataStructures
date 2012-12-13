# Makefile for the Towers of Hanoi

SOURCEPATH=src
BUILDPATH=bin
DOCPATH=doc

MAIN=NULL
MANIFEST=$(SOURCEPATH)/manifest.txt

SOURCES=$(wildcard $(SOURCEPATH)/*.java)

JCOMPFLAGS=-g -classpath $(SOURCEPATH)/ -d $(BUILDPATH)/
JRUNFLAGS=-classpath $(BUILDPATH)/
JARFLAGS=cvfm $(BUILDPATH)/$(MAIN).jar $(MANIFEST)
DOCFLAGS=-classpath $(SOURCEPATH)/ -d $(DOCPATH)/

all: build

build:
	@mkdir -p $(BUILDPATH)
	javac $(JCOMPFLAGS) $(SOURCES)

run:
	java $(JRUNFLAGS) $(MAIN)

doc:
	@mkdir -p $(DOCPATH)
	javadoc $(DOCFLAGS) $(SOURCES)

jar: build
	jar $(JARFLAGS) $(BUILDPATH)

clean:
	rm -rf $(BUILDPATH) $(DOCPATH)