#!/usr/bin/env bash
# Generate Eclipse/VSCode JDTLS .classpath file automatically

CLASSPATH_FILE=".classpath"

cat > "$CLASSPATH_FILE" <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
    <!-- JDK -->
    <classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER"/>
EOF

# Detect all top-level directories containing .java files
for dir in */ ; do
    if find "$dir" -type f -name "*.java" | grep -q .; then
        echo "    <classpathentry kind=\"src\" path=\"${dir%/}\"/>" >> "$CLASSPATH_FILE"
    fi
done

cat >> "$CLASSPATH_FILE" <<EOF
    <!-- Compiled output -->
    <classpathentry kind="output" path="bin"/>
</classpath>
EOF

echo "✅ Generated $CLASSPATH_FILE"

