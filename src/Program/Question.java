package Program;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Question {

    public Question() {
    }

    public boolean startsWithUpper(String s) {
        return Pattern.compile("^[A-Z]").matcher(s).find();
    }

    public int FindPlaceByKey(String s) {
        int capitalInQuest[] = new int[s.length()], countCapital = 0;
        char sArray[] = s.toCharArray();

        for (int i = 1; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                capitalInQuest[countCapital] = i;
                countCapital++;
            }
        }

        for (int i = 0; i < countCapital; i++) {
            if (sArray[capitalInQuest[i] - 2] == 'w') {
                for (int j = i; j < countCapital; j++) {
                    if (j == countCapital-1) {
                        System.out.println("2. " + j + " ostatni " + sArray[capitalInQuest[j]]);
                        return i;
                    } else {
                        System.out.println("2. " + j + " not " + sArray[capitalInQuest[j]]);
                    }
                }
                break;
            }
            if (i == countCapital-1) {
                System.out.println("1. " + i + " ostatni " + sArray[capitalInQuest[i]]);
                return i;
            } else {
                System.out.println("1. " + i + " not " + sArray[capitalInQuest[i]]);
            }
        }
        return 0;
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
        } else if (question.contains("Lennona")) {
            person = "Lennon";
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
