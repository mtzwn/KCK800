package Program;

import java.io.IOException;
import javax.swing.JOptionPane;
import Program.*;

public class KCK {

    public static void main(String[] args) throws IOException {
        System.out.println("Program wystartował.\n");
        String[] database = new String[1000000];
        Question q = new Question();
        Analysis a = new Analysis();
        FileMethods f = new FileMethods();
        String question = null;

        //question = "Kto zabił Kennedy'ego w Dallas?";
        //question = "Kto zabił Kennedy'ego w Los Angeles?";
        //question = "Kto zabił Narutowicza w Warszawie?";
        //question = "Kto zabił Narutowicza w Zachęcie?";
        //question = "Kto Kennedy'ego zabił w Dallas?";
        //question = "Kto w Dallas zabił Kennedy'ego?";
        //question = "Kto zamordował w Dallas Kennedy'ego?";
        //question = "Kto uśmiercił Kennedy'ego w Dallas?";
        //question = "Kto pozbawił życia Kennedy'ego w Dallas?";

        // *
        //question = "Kto zabił Kennedy'ego?";
        //question = "Kto zabił Narutowicza w Dallas?";
        //question = "Kto zabił Oswalda w Dallas?";
         
        
        question = "Kto zabił Niewiadomskiego w Nowym Jorku?";
        //question = "Kto zabił Kennedy'ego u wybrzeża wyspy Martha's Vineyard?";
        //question = "Kto zabił Kennedy'ego w Waszyngtonie?";

        // **
        //question = "Kto zabił?";
        //question = "Kto zabił w Dallas?";
         
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
         String place = q.FindPlaceByKey(question);
         String person = q.FindPersonByKey(question, place);
         System.out.println(place + "  " +person);
         if (q.QuestionAnalysis(question) == false && question == null) {
         JOptionPane.showMessageDialog(null, "Nie podano pytania. Kończenie programu.");
         System.exit(0);
         
         } else if (person == null) {
         JOptionPane.showMessageDialog(null, "Nie podano nazwiska, bądź nie odnaleziono.");
         } else {
         System.out.println("| Pytanie:        " + question);
         System.out.println("| Miejscowość:    " + place);
         System.out.println("| Wybrano osobę:  " + person);
         f.ReadData(database);
         System.out.println("Zapisano dane do bazy tymczasowej.\nAnalizowanie danych w toku...");
         a.DataAnalysis(database, person, place);
         }
         }
    }
}
