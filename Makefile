BASEDIR=$(CURDIR)
OUTPUTDIR=$(BASEDIR)/output
PACKAGE=src

html:
	javadoc "$(PACKAGE)" -d "$(OUTPUTDIR)" -encoding UTF-8

.PHONY: html