package Program;

import javax.swing.JOptionPane;

public class Question {

    public Question() {
    }

    public String AskQuestion() {
        String question = JOptionPane.showInputDialog("Zadaj pytanie:");
        return question;
    }

    public boolean QuestionAnalysis(String question) {
        if (question != null && (question.startsWith("Kto") | question.startsWith("kto")) & question.endsWith("?") & (question.contains("zabi") | question.contains("zamordowa") | question.contains("postrze") | question.contains("zastrzel") | question.contains("ukatrupi") | question.contains("usmierci") | question.contains("pozbawił") | question.contains("uśmierci") | question.contains("pozbawi"))) {
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

    public String GetPlace(String question) {
        if (question.contains(" w ")) {
            char[] questionToArray = question.toCharArray();
            int i = question.indexOf(" w ") + 3;

            while (questionToArray[i] != ' ' && questionToArray[i] != '?') {
                i++;
            }

            int j = i;
            Character sign;
            System.out.println(questionToArray.toString().length());
            if (questionToArray[i] != '?') {
                sign = questionToArray[j + 1];
                if (Character.isUpperCase(sign)) {
                    j++;
                }
            }

            while (questionToArray[j] != ' ' && questionToArray[j] != '?') {
                j++;
            }

            if ((question.substring(question.indexOf(" w ") + 3, j)).contains(GetPerson(question))) {
                return question.substring(question.indexOf(" w ") + 3, i);
            }

            return question.substring(question.indexOf(" w ") + 3, j);
        } else {
            String place = question.substring(question.lastIndexOf(" ") + 1);
            place = place.replace("?", "");
            if (place.contains(GetPerson(question))) {
                JOptionPane.showMessageDialog(null, "Nie podano nazwiska, bądź nie odnaleziono. Kończenie programu.");
                System.exit(0);
            }
            return place;
        }
    }
}
