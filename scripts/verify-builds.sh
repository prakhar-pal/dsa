#!/usr/bin/env bash
javac lc/**/*.java -Xlint:unchecked
find . -name "*.class" | xargs rm
