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
# Solution 1
cnt=0
while read line && [ $cnt -le 10 ]; do
  let 'cnt = cnt + 1'
  if [ $cnt -eq 10 ]; then
    echo $line
    exit 0
  fi
done < file.txt

# Solution 2
awk 'FNR == 10 {print }'  file.txt
# OR
# NR number of record
# NF number of field
awk 'NR == 10' file.txt

# Solution 3 Using stream editor
sed -n 10p file.txt

# Read from the file file.txt and print its transposed content to stdout.
# NF sparated be ' ' or specify with -F $i 
awk '
{
    for (i = 1; i <= NF; i++) {
        if(NR == 1) {
            s[i] = $i;
        } else {
            s[i] = s[i] " " $i;
        }
    }
}
END {
    for (i = 1; s[i] != ""; i++) {
        print s[i];
    }
}' file.txt
