# Bandit OverTheWire Writeup

## Level 0 → Level 1

The password for the next level is stored in a file called `readme` located in the home directory.

Commands you may need to solve this level: `ls`, `cd`, `cat`, `file`, `du`, `find`

### Approach

To find the password for Level 1, we can use the `cat` command to display the contents of the `readme` file in the home directory.

```bash
bandit0@bandit:~$ cat readme
NH2SXQwcBdpmTEzi3bvBHMM9H66vVXjL
```

## Level 1 → Level 2

The password for the next level is stored in a file called `-` located in the home directory.

Commands you may need to solve this level: `ls`, `cd`, `cat`, `file`, `du`, `find`

### Approach

To find the password for Level 2, we can use the `cat` command to display the contents of the `-` file in the home directory.But `-` is a special character in bash, so we need to redirect the contents of the file to the `cat` command using the `<` operator.

```bash
bandit1@bandit:~$ cat < -
rRGizSaX8Mk1RTb1CNQoXTcYZWU6lgzi
```

## Level 2 → Level 3

The password for the next level is stored in a file called `spaces in this filename` located in the home directory.

Commands you may need to solve this level: `ls`, `cd`, `cat`, `file`, `du`, `find`

### Approach

To find the password for Level 3, we can use the `cat` command to display the contents of the `spaces in this filename` file in the home directory. Since the filename contains spaces, we need to escape the spaces using the backslash character `\`.

```bash
bandit2@bandit:~$ ls
spaces in this filename
bandit2@bandit:~$ cat spaces\ in\ this\ filename
aBZ0W5EmUfAf7kHTQeOwd8bauFJ2lAiG

```

## Level 3 → Level 4

The password for the next level is stored in a hidden file in the `inhere` directory.

Commands you may need to solve this level: `ls`, `cd`, `cat`, `file`, `du`, `find`

### Approach

To find the password for Level 4, we can navigate to the `inhere` directory and use the `ls` command with the `-a` flag to list all files, including hidden files. We can then use the `cat` command to display the contents of the `.hidden` file.

```bash
bandit3@bandit:~$ cd inhere/
bandit3@bandit:~/inhere$ ls -a
.  ..  .hidden
bandit3@bandit:~/inhere$ cat .hidden
2EW7BBsr6aMMoJ2HjW067dm8EgX26xNe
```

## Level 4 → Level 5

The password for the next level is stored in the only human-readable file in the inhere directory.
Tip: if your terminal is messed up, try the “reset” command.

Commands you may need to solve this level:ls , cd , cat , file , du , find

### Approach

To find the password for Level 5, we can use the `file` command to determine the type of each file in the `inhere` directory. We are looking for the only human-readable file, which should contain the password.

```bash
bandit4@bandit:~$ file inhere/*
inhere/-file00: data
inhere/-file01: data
inhere/-file02: data
inhere/-file03: data
inhere/-file04: data
inhere/-file05: data
inhere/-file06: data
inhere/-file07: ASCII text
inhere/-file08: data
inhere/-file09: data
bandit4@bandit:~$ cat inhere/-file07
lrIWWI6bB37kxfiCQZqUdOIYfr6eEeqR
```

## Level 5 → Level 6

The password for the next level is stored in a file somewhere under the `inhere` directory and has the following properties:

- Human-readable
- 1033 bytes in size
- Not executable

Commands you may need to solve this level: `ls`, `cd`, `cat`, `file`, `du`, `find`

### Approach

To find the password for Level 6, we can use the `find` command to search for a file in the `inhere` directory that meets the specified criteria (human-readable, 1033 bytes in size, not executable). We can then use the `cat` command to display the contents of the file.

```bash
bandit5@bandit:~$ find ./inhere -type f -size 1033c
./inhere/maybehere07/.file2
bandit5@bandit:~$ cat inhere/maybehere07/.file2
P4L4vucdmLnm8I7Vl7jG1ApGSfjYKqJU
```

## Level 6 → Level 7

The password for the next level is stored somewhere on the server and has the following properties:

- Owned by user `bandit7`
- Owned by group `bandit6`
- 33 bytes in size

Commands you may need to solve this level: `ls`, `cd`, `cat`, `file`, `du`, `find`, `grep`

### Approach

To find the password for Level 7, we can use the `find` command to search for a file on the server that meets the specified criteria (owned by user `bandit7`, owned by group `bandit6`, 33 bytes in size). Here `2` stands for STDERR, all permission denied are redirected to the 1(which is STDOUT, without `&`, 1 is treated as the file name ) and filter out non errors using `|`(pipe), `grep`. We can then use the `cat` command to display the contents of the file.

```bash

bandit6@bandit:~$ bandit6@bandit:~$ find / -type f -user bandit7 -group bandit6 -size 33c 2>&1 | grep -v "Permission denied"
/var/lib/dpkg/info/bandit7.password
find: ‘/proc/1746448/task/1746448/fdinfo/6’: No such file or directory
find: ‘/proc/1746448/fdinfo/5’: No such file or directory
bandit6@bandit:~$ cat /var/lib/dpkg/info/bandit7.password
z7WtoNQU2XfjmMtWA8u5rN4vzqu4v99S
```

## Level 7 → Level 8

The password for the next level is stored in the file `data.txt` next to the word `millionth`.

Commands you may need to solve this level: `man`, `grep`, `sort`, `uniq`, `strings`, `base64`, `tr`, `tar`, `gzip`, `bzip2`, `xxd`

### Approach

To find the password for Level 8, we can use the `grep` command to search for the word `millionth` in the `data.txt` file. We can then display the line containing the word `millionth` to find the password.

```bash
bandit7@bandit:~$cat data.txt | grep "millionth"
millionth       TESKZC0XvTetK0S9xNwm25STk5iWrBvP
```

## Level 8 → Level 9

The password for the next level is stored in the file `data.txt` and is the only line of text that occurs only once.

Commands you may need to solve this level: `grep`, `sort`, `uniq`, `strings`, `base64`, `tr`, `tar`, `gzip`, `bzip2`, `xxd`

### Approach

To find the password for Level 9, first sort the data using the `sort` command and then use the `uniq` command with the `-u` flag to display only the unique lines. The password is the only line of text that occurs only once in the `data.txt` file.

```bash
bandit8@bandit:~$ sort data.txt | uniq -u
EN632PlfYiZbn3PhVK3XOGSlNInNE00t
```

Level 9 password: `EN632PlfYiZbn3PhVK3XOGSlNInNE00t`

## Level 9 → Level 10

The password for the next level is stored in the file `data.txt` in one of the few human-readable strings, preceded by several `=` characters.

Commands you may need to solve this level: `grep`, `sort`, `uniq`, `strings`, `base64`, `tr`, `tar`, `gzip`, `bzip2`, `xxd`

### Approach

To find the password for Level 10, we can use the `strings` command to extract human-readable strings from the `data.txt` file. We can then use the `grep` command to search for the password, which is preceded by several `=` characters.

```bash
bandit9@bandit:~$ cat data.txt | strings | grep "="
=2""L(
x]T========== theG)"
========== passwordk^
Y=xW
t%=q
========== is
4=}D3
{1\=
FC&=z
=Y!m
        $/2`)=Y
4_Q=\
MO=(
?=|J
WX=DA
{TbJ;=l
[=lI
========== G7w8LIi6J3kTb8A7j9LgrywtEUlyyp6s
>8=6
=r=_
=uea
zl=4
```

Level 10 password: `G7w8LIi6J3kTb8A7j9LgrywtEUlyyp6s`
