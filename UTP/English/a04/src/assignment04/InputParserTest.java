/**
 * @Author: Patryk Kamiński
 */

package assignment04;


import java.io.*;

public final class InputParserTest {

    public static void main(String[] args) throws Exception {

        try {
            File listFile = new File("list.txt");
            System.out.println(InputParser.parse(listFile));

        } catch (Exception ex) {
            System.err.println("File has invalid format!");
            ex.printStackTrace();
        }
    }

}