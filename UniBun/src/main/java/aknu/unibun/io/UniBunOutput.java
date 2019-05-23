/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.io;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author aknu
 */
public class UniBunOutput {
    
    
    public void UniBunOutput(String input) throws IOException, Base64DecodingException {
        
        File output = new File("test2.bun");
        Path path = FileSystems.getDefault().getPath(".", "test2.bun");
        
        byte[] bytes = Base64.decode(input);
        
        Files.write(path, bytes);
        
    }
}
