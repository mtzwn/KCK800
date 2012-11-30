package Program;

import java.io.IOException;
import javax.swing.JOptionPane;
import Program.*;

public class KCK {

    public static void main(String[] args) throws IOException {
        System.out.println("Program wystartował.\n");
        String[] database = new String[10000000];
        Question q = new Question();
        Analysis a = new Analysis();
        FileMethods f = new FileMethods();
        String question = null;
        
        question = "Kto zabił Kennedy'ego w Dallas?";

        if (question == null) {
            question = q.AskQuestion();
        }

        if (question == null) {
            JOptionPane.showMessageDialog(null, "Nie podano pytania. Kończenie programu.");
        } else {

            while (q.QuestionAnalysis(question) == false) {
                JOptionPane.showMessageDialog(null, "Zadano błędne pytanie. Proszę wpisz pytanie jeszcze raz.");
                question = q.AskQuestion();
                if (question == null) {
                    JOptionPane.showMessageDialog(null, "Nie podano pytania. Kończenie programu.");
                    System.exit(0);
                }
            }
            if (q.QuestionAnalysis(question) == false && question == null) {
                JOptionPane.showMessageDialog(null, "Nie podano pytania. Kończenie programu.");
                System.exit(0);
            } else if (q.GetPerson(question) == null) {
                JOptionPane.showMessageDialog(null, "Nie podano nazwiska, bądź nie odnaleziono.");
            } else {
                System.out.println("| Miejscowość:    " + q.GetPlace(question));
                System.out.println("| Wybrano osobę:  " + q.GetPerson(question));
                f.ReadData(database);
                System.out.println("Zapisano dane do bazy tymczasowej.\nAnalizowanie danych w toku...");
                a.DataAnalysis(database, q.GetPerson(question), q.GetPlace(question));
            }
        }
    }
}
