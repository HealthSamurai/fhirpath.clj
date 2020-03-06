.PHONY: test

ANTLR_URL = https://storage.googleapis.com/aidbox-public/antlr-4.7.2-complete.jar
ANTLR_PATH  = $(shell echo "`pwd`/tmp/antlr.jar")
ANTLR = java -Xmx500M -cp "${ANTLR_PATH}:$CLASSPATH" org.antlr.v4.Tool

repl:
	clj -A:test:nrepl -e "(-main)" -r

test:
	clj -A:test:runner

gen-parser:
	test -f ${ANTLR_PATH} || curl ${ANTLR_URL} > ${ANTLR_PATH}
	cd parser && rm -rf *class *java && ${ANTLR} -visitor FHIRPath.g4 && env CLASSPATH="${ANTLR_PATH}:$CLASSPATH"  javac *.java
