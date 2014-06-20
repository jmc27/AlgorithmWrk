Jonathan Chu
12/8
Programming Assignment 3

Manifest: Bitwise.java, DirectBlock.javaBitwise.class	MyFileSystem$1.class
Bitwise.java					
DISK						
MyFileSystem.java
DirectBlock.java				Shell.class			
Shell.java
Disk.java					
FileSystem.class				SuperBlock.java
FileSystem.java					TestBitwise.java				
FileTable.java					
FreeMap.java					TestMyFileSystem.java
				
FreeMapBlock.java				Whence.java
IndirectBlock.class				
IndirectBlock.java				
					
Inode.java					readme.txt
				
InodeBlock.java

I certify that this work was completed by me and only me.

I made changes to Bitwise.java and MyFileSystem.java. I use TestBitwise.java to test the changes I made. I noticed there are no tests on clear so I added those in
but they are commented out at the moment. I implemented single, double, and triple indirection using three IdirectBlocks. I was not able to successfully test my implementation
using the Shell or TestMyFileSystem.java classes but I believe it should work. 