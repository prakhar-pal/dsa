#!bin/sh

directory=$(pwd)
search_text="$1"
echo "Searching $search_text"

# Iterate over files in the directory
for file in $(find "$directory" -type d -name .git -prune -o -type f -print); do
    # Check if file is a regular file
    if [ -f "$file" ]; then
        # echo $file
        # Check if the search text exists in the file
        if grep -q "$search_text" "$file"; then
            # Append filename to the search text and replace it in the file
            sed -i '' "s/$search_text/${search_text}$(basename "$file" ".java")/g" "$file"
            echo "Replaced text in file: $file"
        fi
    fi
done
