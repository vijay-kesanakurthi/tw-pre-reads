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

## Level 10 → Level 11

The password for the next level is stored in the file data.txt, which contains base64 encoded data

Commands you may need to solve this level
grep, sort, uniq, strings, base64, tr, tar, gzip, bzip2, xxd

### Approach

To find the password for Level 11, we can use the `base64 -d` command to decode the base64 encoded data in the `data.txt` file.

```bash
bandit10@bandit:~$ cat data.txt | base64 -d
The password is 6zPeziLdR2RKNdNYFNb6nVCKzphlXHBM
```

## Level 11 → Level 12

The password for the next level is stored in the file data.txt, where all lowercase (a-z) and uppercase (A-Z) letters have been rotated by 13 positions

Commands you may need to solve this level
grep, sort, uniq, strings, base64, tr, tar, gzip, bzip2, xxd

### Approach

To find the password for Level 12, we can use the `tr` (translate text) command to rotate the letters in the `data.txt` file by 13 positions. We can then display the contents of the file to find the password.

```bash
bandit11@bandit:~$ cat data.txt | tr 'A-Za-z' 'N-ZA-Mn-za-m'
The password is JVNBBFSmZwKKOP0XbFXOoW8chDz5yVRv
```

### Level 12 → Level 13

The password for the next level is stored in the file data.txt, which is a hexdump of a file that has been repeatedly compressed. For this level it may be useful to create a directory under /tmp in which you can work using mkdir. For example: mkdir /tmp/myname123. Then copy the datafile using cp, and rename it using mv (read the manpages!)

Commands you may need to solve this level
grep, sort, uniq, strings, base64, tr, tar, gzip, bzip2, xxd, mkdir, cp, mv, file

### Approach

To find the password for Level 13, we can create a directory in `/tmp` using the `mkdir` command, copy the `data.txt` file to the new directory using the `cp` command, and rename the file to `hexdump` using the `mv` command. We can then navigate to the new directory and view the contents of the `hexdump` file.

```bash
bandit12@bandit:~$ mkdir /tmp/none
bandit12@bandit:~$ cp data.txt /tmp/none/
bandit12@bandit:~$ cd /tmp/none
bandit12@bandit:~$ mv data.txt hexdump
```

Reverse the hexdump using `xxd` command with flag `-r` to get repeated compressed file.

```bash
bandit12@bandit:~$ xxd -r hexdump compressed
```

The file is compressed using `gzip` compression. So, we can use the `file` command to determine the type of the file and then use the appropriate decompression tool (`gzip -d`) to decompress the file.

```bash
bandit12@bandit:/tmp/none$ file compressed
compressed: gzip compressed data, was "data2.bin", last modified: Thu Oct  5 06:19:20 2023, max compression, from Unix, original size modulo 2^32 573
bandit12@bandit:/tmp/none$ mv compressed compressed.gz
bandit12@bandit:/tmp/none$ gzip -d compressed.gz
bandit12@bandit:/tmp/none$ ls
compressed  hexdump
```

Repeat the process for the decompressed file until you get the ASCII text file.

```bash
bandit12@bandit:/tmp/none$ file compressed
compressed: bzip2 compressed data, block size = 900k
bandit12@bandit:/tmp/none$ mv compressed compressed.bz2
bandit12@bandit:/tmp/none$ bzip2 -d compressed.bz2
bandit12@bandit:/tmp/none$ file compressed
compressed: gzip compressed data, was "data4.bin", last modified: Thu Oct  5 06:19:20 2023, max compression, from Unix, original size modulo 2^32 20480
bandit12@bandit:/tmp/none$ mv compressed compressed.gz
bandit12@bandit:/tmp/none$ gzip -d compressed.gz
bandit12@bandit:/tmp/none$ file compressed
compressed: POSIX tar archive (GNU)
bandit12@bandit:/tmp/none$ mv compressed compressed.tar
bandit12@bandit:/tmp/none$ tar xvf compressed.tar
data5.bin
bandit12@bandit:/tmp/none$ file compressed.tar
compressed.tar: POSIX tar archive (GNU)
bandit12@bandit:/tmp/none$ file data5.bin
data5.bin: POSIX tar archive (GNU)
bandit12@bandit:/tmp/none$ tar xvf data5.bin
data6.bin

bandit12@bandit:/tmp/none$ file data6.bin
data6.bin: bzip2 compressed data, block size = 900k
bandit12@bandit:/tmp/none$ mv data6.bin data6.bin.bz2
bandit12@bandit:/tmp/none$ bzip2 -d data6.bin.bz2


bandit12@bandit:/tmp/none$ file data6.bin
data6.bin: POSIX tar archive (GNU)
bandit12@bandit:/tmp/none$ tar xvf data6.bin
data8.bin
bandit12@bandit:/tmp/none$ file data8.bin
data8.bin: gzip compressed data, was "data9.bin", last modified: Thu Oct  5 06:19:20 2023, max compression, from Unix, original size modulo 2^32 49
bandit12@bandit:/tmp/none$ mv data8.bin data.gz
bandit12@bandit:/tmp/none$ gzip -d data.gz
bandit12@bandit:/tmp/none$ ls
compressed.tar  data  data5.bin  data6.bin  hexdump
bandit12@bandit:/tmp/none$ file data
data: ASCII text
```

Use `cat` command to view the contents of the file.

```bash
bandit12@bandit:/tmp/none$ cat data
The password is wbWdlBxEir4CaE8LaPhauuOo6pwRmrDw
```

### Level 13 → Level 14

The password for the next level is stored in /etc/bandit_pass/bandit14 and can only be read by user bandit14. For this level, you don’t get the next password, but you get a private SSH key that can be used to log into the next level. Note: localhost is a hostname that refers to the machine you are working on

Commands you may need to solve this level
ssh, telnet, nc, openssl, s_client, nmap

### Approach

To find the password for Level 14, we can use the private SSH key provided in the `sshkey.private` file to log in as `bandit14` on the localhost. We can then read the password for Level 14 from the `/etc/bandit_pass/bandit14` file.

```bash
bandit13@bandit:~$ ssh -i sshkey.private -p 2220 bandit14@localhost
bandit14@bandit:~$ cat /etc/bandit_pass/bandit14
fGrHPx402xGC7U7rXKDaxiWFTOiF0ENq
```

### Level 14 → Level 15

The password for the next level can be retrieved by submitting the password of the current level to port 30000 on localhost.

Commands you may need to solve this level
ssh, telnet, nc, openssl, s_client, nmap

### Approach

To find the password for Level 15, we can use the `telnet` command to connect to port 30000 on localhost and submit the password for Level 14. The password for Level 15 will be displayed after submitting the password for Level 14.

```bash
bandit14@bandit:~$ telnet localhost 30000
Trying 127.0.0.1...
Connected to localhost.
Escape character is '^]'.
fGrHPx402xGC7U7rXKDaxiWFTOiF0ENq
Correct!
jN2kgmIXJ6fShzhT2avhotn4Zcka6tnt
Connection closed by foreign host.
```

### Level 15 → Level 16

The password for the next level can be retrieved by submitting the password of the current level to port 30001 on localhost using SSL encryption.

Helpful note: Getting “HEARTBEATING” and “Read R BLOCK”? Use -ign_eof and read the “CONNECTED COMMANDS” section in the manpage. Next to ‘R’ and ‘Q’, the ‘B’ command also works in this version of that command…

Commands you may need to solve this level
ssh, telnet, nc, openssl, s_client, nmap

### Approach

To find the password for Level 16, we can use the `openssl s_client` command to connect to port 30001 on localhost using SSL encryption and submit the password for Level 15. The password for Level 16 will be displayed after submitting the password for Level 15.

```bash
bandit15@bandit:~$ echo "jN2kgmIXJ6fShzhT2avhotn4Zcka6tnt" | openssl s_client  -connect localhost:30001 -ign_eof
read R BLOCK
Correct!
JQttfApK4SeyHwDlI9SXGR50qclOAil1
closed
```

### Level 16 → Level 17

The credentials for the next level can be retrieved by submitting the password of the current level to a port on localhost in the range 31000 to 32000. First find out which of these ports have a server listening on them. Then find out which of those speak SSL and which don’t. There is only 1 server that will give the next credentials, the others will simply send back to you whatever you send to it.

Commands you may need to solve this level
ssh, telnet, nc, openssl, s_client, nmap

### Approach

To find the password for Level 17, we can use the `nmap` command to scan the ports in the range 31000 to 32000 on localhost and identify the port that has a server listening on it. We can then use the `openssl s_client` command to connect to the identified port using SSL encryption and one port gives the private key.Copy the private key into local machine and use it to login to bandit17.

```bash
bandit16@bandit:~$ nmap -p31000-32000 localhost
Starting Nmap 7.80 ( https://nmap.org ) at 2024-04-11 03:39 UTC
Nmap scan report for localhost (127.0.0.1)
Host is up (0.00013s latency).
Not shown: 996 closed ports
PORT      STATE SERVICE
31046/tcp open  unknown
31518/tcp open  unknown
31691/tcp open  unknown
31790/tcp open  unknown
31960/tcp open  unknown
bandit16@bandit:~$ openssl s_client --connect localhost:31790
-----BEGIN RSA PRIVATE KEY-----

Vijay@vijay:~$ ssh -i key.private bandit17@bandit.labs.overthewire.org -p 2220
```

### Level 17 → Level 18

There are 2 files in the homedirectory: passwords.old and passwords.new. The password for the next level is in passwords.new and is the only line that has been changed between passwords.old and passwords.new

NOTE: if you have solved this level and see ‘Byebye!’ when trying to log into bandit18, this is related to the next level, bandit19

### Approach

To find the password for Level 18, we can use the `diff` command to compare the `passwords.old` and `passwords.new` files and identify the line that has been changed between the two files. The password for Level 18 is the only line that has been changed.

```bash
bandit17@bandit:~$ diff passwords.new passwords.old
42c42
< hga5tuuCLF6fFzUpnagiMN8ssu9LFrdg
---
> p6ggwdNHncnmCNxuAt0KtKVq185ZU7AW
```

### Level 18 → Level 19

The password for the next level is stored in a file readme in the homedirectory. Unfortunately, someone has modified .bashrc to log you out when you log in with SSH.

Commands you may need to solve this level
ssh, ls, cat

### Approach

To find the password for Level 19, we can use the `ssh` command and execute the `cat` command to display the contents of the `readme` file in the home directory.

```bash
Vijay@Vijay:~$ ssh bandit18@bandit.labs.overthewire.org -p 2220 "cat readme"
bandit18@bandit.labs.overthewire.org's password:
awhqfNnAbc1naukrpqDYcF95h7HoMTrC
```

### Level 19 → Level 20

To gain access to the next level, you should use the setuid binary in the homedirectory. Execute it without arguments to find out how to use it. The password for this level can be found in the usual place (/etc/bandit_pass), after you have used the setuid binary.

### Approach

To find the password for Level 20, we can use the `bandit20-do` setuid binary in the home directory. We can execute the binary without arguments to find out how to use it and then use it to read the password for Level 20 from the `/etc/bandit_pass/bandit20` file.

```bash
bandit19@bandit:~$ ls -la
total 36                                                                                                                drwxr-xr-x  2 root     root      4096 Oct  5  2023 .
drwxr-xr-x 70 root     root      4096 Oct  5  2023 ..
-rwsr-x---  1 bandit20 bandit19 14876 Oct  5  2023 bandit20-do
-rw-r--r--  1 root     root       220 Jan  6  2022 .bash_logout
-rw-r--r--  1 root     root      3771 Jan  6  2022 .bashrc
-rw-r--r--  1 root     root       807 Jan  6  2022 .profile
bandit19@bandit:~$ ./bandit20-do cat /etc/bandit_pass/bandit20
VxCazJaVykI6W36BkBU0mJTCM8rR95XT
```

### Level 20 → Level 21

here is a setuid binary in the homedirectory that does the following: it makes a connection to localhost on the port you specify as a commandline argument. It then reads a line of text from the connection and compares it to the password in the previous level (bandit20). If the password is correct, it will transmit the password for the next level (bandit21).

NOTE: Try connecting to your own network daemon to see if it works as you think

### Approach

To find the password for Level 21, we can use the `suconnect` setuid binary in the home directory. We can execute the binary with the password for Level 20 as an argument to establish a connection to localhost on a specified port. So create a listener on the port 1234 , send the password to the listener and then execute the `suconnect` binary with the port number as an argument.

```bash
bandit20@bandit:~$  echo  "VxCazJaVykI6W36BkBU0mJTCM8rR95XT" | nc -lv 1234 & ./suconnect 1234
[1] 137823                                                                                                              Listening on 0.0.0.0 1234
Connection received on localhost 32934
Read: VxCazJaVykI6W36BkBU0mJTCM8rR95XT
Password matches, sending next password
NvEJF7oVjkddltPSrdKEFOllh9V1IBcq
```
