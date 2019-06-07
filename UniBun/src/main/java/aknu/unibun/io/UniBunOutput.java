/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This class will export a "filename.bun" that will be noticeably smaller than
 * the original file.
 *
 * @author aknu
 */
public class UniBunOutput {

    File output;
    Path path;

    public void UniBunOutput(byte[] input) throws IOException {

        File output = new File("test22.bun");
        Path path = FileSystems.getDefault().getPath(".", "test22.bun");
        int j = 0;
        int ptr1;
        
        /* for (int i = 0; i < input.length; i++) {
            
            byte a = input[i];
            a = (byte) ( a & 0xFF);
            while ((a >> j) == 0) {
                j++;
            }
            ptr1 = j;
            
            while (j < 8) {
                if (((a >> j) && 1)) {
                
            
            }
            
        } */
        
        
        Files.write(path, input);

    }

    public void decodeFile(byte[] input) throws IOException {
        output = new File("decomp");
        path = FileSystems.getDefault().getPath(".", "decomp");

        Files.write(path, input);

    }
}
