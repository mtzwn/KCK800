package Program;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Question {

    public Question() {
    }

    public boolean startsWithUpper(String s) {
        return Pattern.compile("^[A-Z]").matcher(s).find();
    }

    public String FindPlaceByKey(String s) {
        int capitalInQuest[] = new int[s.length()], countCapital = 0;
        char sArray[] = s.toCharArray();

        for (int i = 1; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                capitalInQuest[countCapital] = i;
                countCapital++;
            }
        }
        if (countCapital == 2) {

            for (int i = 0; i < countCapital; i++) {
                if (sArray[capitalInQuest[i] - 2] == 'w') {

                    int k = capitalInQuest[i];
                    while (sArray[k] != ' ' && sArray[k] != '?') {
                        k++;
                    }

                    return PlaceFormChange(s.substring(capitalInQuest[i], k));
                }
            }
        } else if (countCapital == 3) {
            for (int i = 0; i < countCapital; i++) {
                if (sArray[capitalInQuest[i] - 2] == 'w') {

                    int k = capitalInQuest[i];
                    while (sArray[k] != ' ' && sArray[k] != '?') {
                        k++;
                    }
                    if (sArray[k] != '?') {
                        k++;
                    }

                    while (sArray[k] != ' ' && sArray[k] != '?') {
                        k++;
                    }

                    return PlaceFormChange(s.substring(capitalInQuest[i], k));
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Nie podano miejsca, bądź nie odnaleziono. Kończenie programu.");
        System.exit(0);
        return "";
    }

    public String FindPersonByKey(String s, String place) {
        int capitalInQuest[] = new int[s.length()], countCapital = 0;
        char sArray[] = s.toCharArray();

        for (int i = 1; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                capitalInQuest[countCapital] = i;
                countCapital++;
            }
        }
        for (int i = 0; i < countCapital; i++) {
            if (sArray[capitalInQuest[i] - 2] != 'w') {

                int k = capitalInQuest[i];
                while (sArray[k] != ' ' && sArray[k] != '?') {
                    k++;
                }
                if (!place.contains(s.substring(capitalInQuest[i], k))) {
                    return PersonFormChange(s.substring(capitalInQuest[i], k));
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Nie podano miejsca, bądź nie odnaleziono. Kończenie programu.");
        System.exit(0);
        return "";
    }

    public String PersonFormChange(String person) {

        String personForm;

        if (person.length() < 4) {
            personForm = person.substring(0, person.length() - 1);
        } else if (person.length() < 7) {
            personForm = person.substring(0, person.length() - 2);
        } else {
            personForm = person.substring(0, person.length() - 3);
        }

        return personForm.replace("'", "").replace("?", "").replace("-", "").replace(".", "");
    }

    public String PlaceFormChange(String place) {

        String placeForm;

        if (place.length() < 4) {
            placeForm = place.substring(0, place.length() - 1);
        } else if (place.length() < 7) {
            placeForm = place.substring(0, place.length() - 2);
        } else {
            placeForm = place.substring(0, place.length() - 3);
        }

        return placeForm.replace("'", "").replace("?", "").replace("-", "").replace(".", "");
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
}
