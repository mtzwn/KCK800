package Program;

import java.util.regex.Pattern;

public class Analysis {

    public Analysis() {
    }

    public boolean startsWithUpper(String s) {
        return Pattern.compile("^[A-Z]").matcher(s).find();
    }

    public void DataAnalysis(String[] database, String person, String place) {
        int i = 0, found = 0, wordCount = 0, personCount = 0, upperWordCount = 0, verbCount = 0, placeCount = 0;
        int[] personID = new int[10000000];
        int[] UpperNameWordID = new int[10000000];
        int[] verbID = new int[10000000];
        int[] answerID = new int[10000000];
        int[] placeID = new int[10000000];

        //------------!Wyszukuje miejsce w bazie
        while (database[i] != null) {
            if (database[i].contains(place)) {
                placeID[placeCount] = i;
                placeCount++;
            }
            wordCount++;
            i++;
        }
        System.out.println("\nBaza liczy " + wordCount + " słowa.\nZnaleziono " + placeCount + " miejscowości pasujących w tekście.");

        //------------!Wyszukuje osobe zabita w bazie
        i = 0;
        while (i < placeCount) {
            int k = placeID[i] - 20;
            if (k < 0) {
                k = 0;
            }
            int l = placeID[i] + 20;

            while (k < l) {
                if (database[k].contains(person)) {
                    personID[personCount] = k;
                    personCount++;
                }
                k++;
            }
            i++;
        }
        System.out.println("Znaleziono " + personCount + " ofiar w tekście na podstawie miejscowości.");

        //------------! Wyszukuje czasownika związanego z zabójstwem
        i = 0;
        while (i < personCount) {
            int k = personID[i] - 20;
            if (k < 0) {
                k = 0;
            }
            int l = personID[i] + 20;

            while (k <= l) {
                if (database[k].contains("zabi") | database[k].contains("zamordowa") | database[k].contains("zastrzel") | database[k].contains("postrzel") | database[k].contains("ukatrupi") | database[k].contains("usmierci") | database[k].contains("zabój") | database[k].contains("morder") | database[k].contains("przestęp") | database[k].contains("bandyt") | database[k].contains("terrory") | database[k].contains("Zabi") | database[k].contains("Zamordowa") | database[k].contains("Zastrzel") | database[k].contains("Ukatrupi") | database[k].contains("Usmierci") | database[k].contains("Zabój") | database[k].contains("Morder") | database[k].contains("Przestęp") | database[k].contains("Bandyt") | database[k].contains("Terrory")) {
                    verbID[verbCount] = k;
                    verbCount++;
                }
                k++;
            }
            i++;
        }
        System.out.println("Znaleziono " + verbCount + " czasowników w tekście na podstawie miejscowości oraz ofiary.");

        //------------! Wyszukuje wyrazów zaczynających się z wielkich liter
        i = 0;
        while (i < verbCount) {
            int k = verbID[i] - 20;
            if (k < 0) {
                k = 0;
            }
            int l = verbID[i] + 20;
            while (k < l) {
                if (startsWithUpper(database[k])) {
                    UpperNameWordID[upperWordCount] = k;
                    upperWordCount++;
                }
                k++;
            }
            i++;
        }
        System.out.println("Znaleziono " + upperWordCount + " wyrazów w tekście zaczynających się wielką literą na podstawie miejscowości, ofiary i czasownika.");
        System.out.println("--------------------------");

        ////------------! Wyszukuje odpowiedzi na podstawie powyższych warunków
        i = 0;
        while (i < upperWordCount) {
            int k = UpperNameWordID[i] - 20;
            if (k < 0) {
                k = 0;
            }
            int l = UpperNameWordID[i] + 20;

            while (k < l) {
                if (found == 1) {
                    break;
                }
                if ((database[k].contains("przez") | database[k].contains("zabił") | database[k].contains("zamordował") | database[k].contains("postrzelił") | database[k].contains("zastrzelił") | database[k].contains("ukatrupił") | database[k].contains("usmiercił")) & (startsWithUpper(database[k + 1]) | startsWithUpper(database[k + 2]) | startsWithUpper(database[k + 3]) | startsWithUpper(database[k + 3]))) {
                    for (int r = 0; r < 5; r++) {
                        if (startsWithUpper(database[k + r])) {
                            System.out.print(database[k + r] + " ");
                        }
                    }
                    found = 1;
                    break;
                }
                k++;
            }
            i++;
        }
        if (found == 0) {
            System.out.print("Nie znaleziono zabójcy w tekscie lub niezgadzają sie dane miejsca/osoby/zapytania");
        }
        System.out.println("\n--------------------------");
    }
}
