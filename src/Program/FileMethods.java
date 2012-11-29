/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.awt.FileDialog;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Dicas NTB
 */
public class FileMethods {

    public FileMethods() {
    }

    public void ReadData(String[] database) throws FileNotFoundException {

        try {
            Charset charset = Charset.forName("cp1250");
            File fileDefault = new File("C:\\baza.txt");
            String fileName = "C:\\baza.txt";
            if (fileDefault.exists() == false) {
                fileName = FindFile();
            }

            int i = 0;
            Scanner input = new Scanner(new InputStreamReader(new FileInputStream(fileName), charset));
            while (input.hasNext()) {
                database[i] = input.next().replace(",", "").replace("(", "").replace(")", "").replace(":", "").replace(";", "").replace("!", "").replace("?", "").replace("'", "");
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String FindFile() {
        String choose = null;
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));
        FileDialog fd = new FileDialog(frame, "Wybierz plik", FileDialog.LOAD);
        fd.setVisible(true);
        choose = fd.getDirectory() + fd.getFile();
        fd.dispose();
        frame.dispose();
        return choose;
    }
}
