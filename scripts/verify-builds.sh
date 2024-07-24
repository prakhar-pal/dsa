#!/usr/bin/env bash
javac lc/**/*.java
find . -name "*.class" | xargs rm
