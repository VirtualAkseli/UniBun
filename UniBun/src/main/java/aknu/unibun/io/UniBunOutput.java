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
import java.util.Arrays;

/**
 * This class will eventually export a "filename.bun" that will be noticeably
 * smaller than the original file.
 *
 * @author aknu
 */
public class UniBunOutput {

    File output;
    Path path;

    public void CompressToFile(String[] input, int size) throws IOException {
        byte[] placeholder = new byte[size];

        int ptr = 0;
        int overFlow = 0;
        int underFlow = 0;
        int slotsFilled = 0;
        String huffBits;

        for (int i = 0; i < input.length; i++) {
            if (i == size) {
                break;
            }
            huffBits = input[i];

            if (huffBits.length() < 8) {
                underFlow = (8 - (huffBits.length() % 8));

                while (ptr < huffBits.length()) {

                    if (huffBits.charAt(ptr) == '1') {

                        placeholder[i] = (byte) (placeholder[i] << 1);
                        placeholder[i] = (byte) (placeholder[i] | 00000001);
                        ptr++;

                    } else {

                        placeholder[i] = (byte) (placeholder[i] << 1);
                        ptr++;

                    }

                }
                ptr = 0;
                if (i + 1 < size) {
                    i++;
                    huffBits = input[i];
                    while (ptr < huffBits.length()) {
                        if (huffBits.charAt(ptr) == '1') {
                            placeholder[i - 1] = (byte) (placeholder[i - 1] << 1);
                            placeholder[i] = (byte) (placeholder[i] | 00000001);
                            ptr++;

                        } else {
                            placeholder[i] = (byte) (placeholder[i] << 1);
                            ptr++;
                        }
                    }
                    
                    i--;
                    ptr = 0;
                    huffBits = input[i];
                }

            }

            if (huffBits.length() > 7) {
                overFlow = huffBits.length() % 8;
                while (ptr < huffBits.length()) {

                    if (huffBits.charAt(ptr) == '1') {

                        placeholder[i] = (byte) (placeholder[i] << 1);
                        placeholder[i] = (byte) (placeholder[i] | 00000001);
                        ptr++;

                    } else {

                        placeholder[i] = (byte) (placeholder[i] << 1);
                        ptr++;

                    }

                }
                ptr = 0;
                if (i++ < input.length) {
                    i++;
                    huffBits = input[i];
                    while (ptr < huffBits.length()) {
                        if (huffBits.charAt(ptr) == '1') {
                            placeholder[i - 1] = (byte) (placeholder[i - 1] << 1);
                            placeholder[i] = (byte) (placeholder[i] | 00000001);
                            ptr++;

                        } else {
                            placeholder[i] = (byte) (placeholder[i] << 1);
                            ptr++;
                        }
                    }
                    i--;
                }

            }

            if (ptr > 7) {
                i++;

                while (ptr < huffBits.length()) {

                    if (huffBits.charAt(ptr) == '1') {
                        if (i < 20) {
                            System.out.print("1");

                        }
                        placeholder[i] = (byte) (placeholder[i] << 1);
                        placeholder[i] = (byte) (placeholder[i] | 00000001);
                        ptr++;

                    } else {
                        if (i < 20) {
                            System.out.print("0");
                        }
                        placeholder[i] = (byte) (placeholder[i] << 1);
                        ptr++;

                    }

                }

            }

        }

        output = new File("test22.bun");
        Path path = FileSystems.getDefault().getPath(".", "test22.bun");
        System.out.println("");
       

        Files.write(path, placeholder);

    }

    
    
    public void decodeFile(byte[] input) throws IOException {
        output = new File("decomp");
        path = FileSystems.getDefault().getPath(".", "decomp");

        Files.write(path, input);

    }
}
