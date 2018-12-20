cd parser

alias antlr4='java -Xmx500M -cp "antlr-4.7.2-complete.jar:$CLASSPATH" org.antlr.v4.Tool'
env CLASSPATH="`pwd`/antlr-4.7.2-complete.jar:$CLASSPATH"  javac FHIR*.java
antlr4 -visitor FHIRPath.g4
