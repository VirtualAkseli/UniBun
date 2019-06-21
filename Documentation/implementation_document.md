# Implementation document

## Summary
The work that I started 7 weeks ago did not get finished. At its current state, the program gives an approximation of how efficiently Huffman's algorithm would compress the given file. I strongly recommend on testing with .txt files and images.



No analysis for time- & space-complexity has been done, but the efficiency of the program is printed after the "compression" has been made.

The current flaws and needs for improvement are:
- Getting the compression to work actually work, the current output is gibberish with no use.
- Decoding from the compressed file
- Implementing Tree so that it actually works as an minimun-tree, I could not make it work with the program, however, one can see from the tests that some features are working correctly.

## Sources:
- [Lossless data compression, general info](https://www.maximumcompression.com/algoritms.php "link1")
- [Data compression, Matt Mahoney 2012](http://mattmahoney.net/dc/dce.html "link2")
- [Huffman Coding, A CS2 assignment](https://www2.cs.duke.edu/csed/poop/huff/info/ "link3")
- [Bit Manipulation in Java](https://www.vojtechruzicka.com/bit-manipulation-java-bitwise-bit-shift-operations/ "link 4")
- [HuffmanHowTo](https://www.cs.utexas.edu/~scottm/cs314/javacode/A10_Huffman/HuffmanHowTo.htm "link 5")
