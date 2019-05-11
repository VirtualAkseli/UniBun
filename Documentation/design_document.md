# Project definition

## Use and purpose
The objective is to create a program that compresses (bundles) files given to it. 
Files can also be decompressed (unbundled) back to their original form.

## Algorithms
The plan is to use Huffman coding and Arithmetic coding. Both of these are essential to 
lossless compression, but Arithemtic coding should bring better results faster since it makes better use
of today's heightened processing capabilities.

Huffman's time comlexity varies, but Arithmetic should bring O(n logn) results.

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
- GUI with the ability to compare the implemented algortihms and their effectiveness.
