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
    
    
    public void UniBunOutput(String input) throws IOException {
        
        File output = new File("test2.bun");
        Path path = FileSystems.getDefault().getPath(".", "test2.bun");
        
        byte[] bytes = input.getBytes();
        
        Files.write(path, bytes);
        
    }
}
