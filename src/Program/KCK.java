package Program;

import java.io.IOException;
import javax.swing.JOptionPane;
import Program.*;

public class KCK {

    public static void main(String[] args) throws IOException {
        String[] database = new String[10000000];
        Question q = new Question();
        Analysis a = new Analysis();
        FileMethods f = new FileMethods();


        String question = q.AskQuestion();
        //String pytanie = null;
        //pytanie = "Kto zabił Kennedy'ego w Dallas?";

        if (question == null) {
            JOptionPane.showMessageDialog(null, "Nie podano pytania. Kończenie programu.");
        } else {

            while (q.QuestionAnalysis(question) == false) {
                JOptionPane.showMessageDialog(null, "Zadano błędne pytanie. Proszę wpisz pytanie jeszcze raz.");
                question = q.AskQuestion();
                if (question == null) {
                    JOptionPane.showMessageDialog(null, "Nie podano pytania. Kończenie programu.");
                    break;
                }
            }
            if (q.QuestionAnalysis(question) == false && question == null) {
                JOptionPane.showMessageDialog(null, "Nie podano pytania. Kończenie programu.");
            } else if (q.GetPerson(question) == null) {
                JOptionPane.showMessageDialog(null, "Nie podano nazwiska, bądź nie odnaleziono.");
            } else {
                System.out.println("Nazwisko: " + q.GetPerson(question));
                System.out.println("Miejscowość: " + q.GetPlace(question));
                f.ReadData(database);
                a.DataAnalysis(database, q.GetPerson(question), q.GetPlace(question));
            }
        }
    }
}
