# Project definition

## Use and purpose
The objective is to create a program that compresses (bundles) files given to it. 
Files can also be decompressed (unbundled) back to their original form.

Files need to be converted to binary/String and then, according to the frequency of the symbols, a Huffman tree is set, with the root node including all the other nodes as its children. The nodes are either combinations of symbols or the symbols themselves. Individual symbols are then encoded into shorter binary versions of the original binary form. __This explanation will be enhanced once I get a better understanding of the algorithms.__ 

## Algorithms
The plan is to use Huffman coding and Arithmetic coding. Both of these are essential to 
lossless compression, but Arithemtic coding should bring better results faster since it makes better use
of today's heightened processing capabilities.

I will need to implement a heap for the Huffman code, and lists for keeping track of the different weights that the strings individual characters get.

Huffman's time complexity varies, but Arithmetic should bring O(n logn) results.

`` Note: I will update this section as I learn and strengthen my understanding of the subject and the algorithms I am using ``

## Reference material (I will update this list as I find more information)
- [Lossless data compression, general info](https://www.maximumcompression.com/algoritms.php9 "link1")
- [Data compression, Matt Mahoney 2012](http://mattmahoney.net/dc/dce.html "link2")

## Implementation
### Input
I will make it so, that the program compresses files, regardless of their type. 
### Output 
.bun -files that can be later decompressed back to their original form.
Efficiency regarding the compression rate and speed will be written to the console for inspection.
### UI
The program will be ran from the command line and hence the ui will be a textual one.

## Ideas for further development
- GUI with the ability to compare the implemented algorithms and their effectiveness.
