package Program;

import java.util.regex.Pattern;
import javax.swing.JTextArea;

public class Analysis {

    public Analysis() {
    }

    public boolean startsWithUpper(String s) {
        return Pattern.compile("^[A-Z]").matcher(s).find();
    }

    public void DataAnalysis(String[] database, String person, String place, ShowText console) {
        int i = 0, found = 0, wordCount = 0, personCount = 0, upperWordCount = 0, verbCount = 0, placeCount = 0, l = 0;
        int[] personID = new int[100000];
        int[] UpperNameWordID = new int[100000];
        int[] verbID = new int[100000];
        int[] placeID = new int[100000];

        //------------!Wyszukuje miejsce w bazie
        while (database[i] != null) {
            if (database[i].contains(place)) {
                placeID[placeCount] = i;
                placeCount++;
            }
            wordCount++;
            i++;
        }

        console.sendMsg("\nBaza liczy " + wordCount + " słowa.\nZnaleziono " + placeCount + " miejscowości pasujących w tekście.");

        //------------!Wyszukuje osobe zabita w bazie
        i = 0;
        while (i < placeCount & i < wordCount) {
            int k = placeID[i] - 20;
            if (k < 0) {
                k = 0;
            }
            if (placeID[i] + 20 < wordCount) {
                l = placeID[i] + 20;
            }
            while (k < l && k < wordCount) {
                if (database[k].contains(person)) {
                    personID[personCount] = k;
                    personCount++;
                }
                k++;
            }
            i++;
        }
        console.sendMsg("Znaleziono " + personCount + " ofiar w tekście na podstawie miejscowości.");

        //------------! Wyszukuje czasownika związanego z zabójstwem
        i = 0;
        while (i < personCount) {
            int k = personID[i] - 20;
            if (k < 0) {
                k = 0;
            }
            l = personID[i] + 20;

            while (k <= l & k < wordCount) {
                if (database[k].contains("zabi") | database[k].contains("zamordowa") | database[k].contains("zastrzel") | database[k].contains("postrzel") | database[k].contains("ukatrupi") | database[k].contains("usmierci") | database[k].contains("zabój") | database[k].contains("morder") | database[k].contains("przestęp") | database[k].contains("bandyt") | database[k].contains("terrory") | database[k].contains("Zabi") | database[k].contains("Zamordowa") | database[k].contains("Zastrzel") | database[k].contains("Ukatrupi") | database[k].contains("Usmierci") | database[k].contains("Zabój") | database[k].contains("Morder") | database[k].contains("Przestęp") | database[k].contains("Bandyt") | database[k].contains("Terrory")) {
                    verbID[verbCount] = k;
                    verbCount++;
                }
                k++;
            }
            i++;
        }
        console.sendMsg("Znaleziono " + verbCount + " czasowników w tekście na podstawie miejscowości oraz ofiary.");

        //------------! Wyszukuje wyrazów zaczynających się z wielkich liter
        i = 0;
        while (i < verbCount) {
            int k = verbID[i] - 20;
            if (k < 0) {
                k = 0;
            }
            l = verbID[i] + 20;
            while (k < l) {
                if (startsWithUpper(database[k])) {
                    UpperNameWordID[upperWordCount] = k;
                    upperWordCount++;
                }
                k++;
            }
            i++;
        }
        console.sendMsg("Znaleziono " + upperWordCount + " wyrazów w tekście zaczynających się wielką literą na podstawie miejscowości, ofiary i czasownika.");
        console.sendMsg("--------------------------");

        ////------------! Wyszukuje odpowiedzi na podstawie powyższych warunków
        i = 0;
        while (i < upperWordCount) {
            int k = UpperNameWordID[i] - 20;
            if (k < 0) {
                k = 0;
            }
            l = UpperNameWordID[i] + 20;

            String zabojca = new String();
            while (k < l & k < wordCount) {
                if (found == 1) {
                    break;
                }
                if ((database[k].contains("przez") | database[k].contains("zabił") | database[k].contains("zamordował") | database[k].contains("postrzelił") | database[k].contains("zastrzelił") | database[k].contains("ukatrupił") | database[k].contains("usmiercił")) & (startsWithUpper(database[k + 1]) | startsWithUpper(database[k + 2]) | startsWithUpper(database[k + 3]) | startsWithUpper(database[k + 3]))) {
                    for (int r = 0; r < 5; r++) {
                        if (k + r > wordCount) {
                            break;
                        }
                        if (startsWithUpper(database[k + r])) {
                            zabojca = zabojca + database[k + r] + " ";
                        }
                    }
                    found = 1;
                    if (zabojca.contains(person)) {
                        found = 0;
                        break;
                    } else {
                        console.sendMsg("Zabójca to: " + zabojca.substring(0, zabojca.length() - 1));
                        break;
                    }
                }
                k++;
            }
            i++;
        }
        if (found == 0) {
            console.sendMsg("Nie znaleziono zabójcy w tekscie lub nie zgadzają się dane miejsca/osoby/zapytania");
        }
        // console.sendMsg("\nPodstawy odpowiedzi: ");
        console.sendMsg("--------------------------");
    }
}
