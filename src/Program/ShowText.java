/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import javax.swing.JTextArea;

/**
 *
 * @author Dicas NTB
 */
public class ShowText {
    
    private JTextArea display = new JTextArea();
    
    public JTextArea getDisplay() {
        return display;
    }
    
    public void setDisplay(JTextArea showTextConsole) {
        display = showTextConsole;
    }
    
    public void sendMsg(String msg) {
        getDisplay().append(msg + "\n");
    }
}
