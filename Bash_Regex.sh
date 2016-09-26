# Match letter and digits abc / 124
# ANg Digit \d, any Non-Digit character \D
# . any character; \. period
# [abc] Match only a,b,c [^abc] Match not a,b,c
# [a-z] character a to z; [1-9] numbers 1-9
# \w any alphanumeric character \W any Non-alphanumeric character
# {m} m Repetition; {m, n} m to n Repetition
# * zero or more repetition; + one or more repetition; ? optional character
# \s any whitespace; \S any non-white Space character
# ^......$ indicate start to end of a line
# (...) capture group; (.*) Capture all; (a(bc)) group capture; (abc|bdc) Match abc or bdc



grep -P "^(\d{3}-|\([0-9]{3}\) )\d{3}-\d{4}$" file.txt

# Read from the file file.txt and output the tenth line to stdout.
count=0
while read line && [ $count -le 10 ]; do
    let 'count += 1'
    if [ $count -eq 10 ]; then
        echo $line
        exit 0
        #return
    fi
done < file.txt
