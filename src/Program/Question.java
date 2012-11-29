/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import javax.swing.JOptionPane;

/**
 *
 * @author Dicas NTB
 */
public class Question {

    public Question() {
    }

    public String AskQuestion() {
        String question = JOptionPane.showInputDialog("Zadaj pytanie:");
        return question;
    }

    public boolean QuestionAnalysis(String question) {
        if (question != null && (question.startsWith("Kto") | question.startsWith("kto")) & question.endsWith("?") & (question.contains("zabi") | question.contains("zamordowa") | question.contains("postrze") | question.contains("zastrzel") | question.contains("ukatrupi") | question.contains("usmierci"))) {
            return true;
        } else {
            return false;
        }
    }

    public String GetPerson(String question) {
        String person = null;
        if (question.contains("Narutow")) {
            person = "Narutowicz";
        } else if (question.contains("Kenned")) {
            person = "Kennedy";
        } else if (question.contains("Lincol")) {
            person = "Lincoln";
        } else if (question.contains("Oswald")) {
            person = "Oswald";
        } else if (question.contains("Niewiadomsk")) {
            person = "Niewiadomski";
        } else {
            return person;
        }
        return person;
    }

    public String GetPlace(String pytanie) {
        String place = pytanie.substring(pytanie.lastIndexOf(" ") + 1);
        place = place.replace("?", "");
        return place;
    }
}
