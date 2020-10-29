BASEDIR=$(CURDIR)
OUTPUTDIR=$(BASEDIR)/output
PACKAGE=src

html:
	javadoc "$(PACKAGE)" -d "$(OUTPUTDIR)"

.PHONY: html