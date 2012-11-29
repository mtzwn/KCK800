/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.regex.Pattern;

/**
 *
 * @author Dicas NTB
 */
public class Analysis {

    public Analysis() {
    }

    public boolean startsWithUpper(String s) {
        return Pattern.compile("^[A-Z]").matcher(s).find();
    }

    public void DataAnalysis(String[] database, String person, String place) {
        int i = 0, j = 0, m = 0, t = 0, msce = 0;
        int[] czasID = new int[10000000];
        int[] capsNazwID = new int[10000000];
        int[] nazwCzasownikID = new int[10000000];
        int[] odpowiedzID = new int[10000000];
        int[] miejsceID = new int[10000000];
        int found = 0;

        int licznikSlow = 0;
        int licznikSlowNazwisko = 0;
        int licznikDuzychSlow = 0;
        int licznikSlowIKeyword = 0;
        int licznikMiejsc = 0;

        while (database[i] != null) {
            if (database[i].contains("zabi") | database[i].contains("zamordowa") | database[i].contains("zastrzel") | database[i].contains("postrzel") | database[i].contains("ukatrupi") | database[i].contains("usmierci") | database[i].contains("zabój") | database[i].contains("morder") | database[i].contains("przestęp") | database[i].contains("bandyt") | database[i].contains("terrory") | database[i].contains("Zabi") | database[i].contains("Zamordowa") | database[i].contains("Zastrzel") | database[i].contains("Ukatrupi") | database[i].contains("Usmierci") | database[i].contains("Zabój") | database[i].contains("Morder") | database[i].contains("Przestęp") | database[i].contains("Bandyt") | database[i].contains("Terrory")) {
                czasID[j] = i;
                j++;
                licznikSlowIKeyword++;
            }
            i++;
            licznikSlow++;
        }
        // System.out.println(i + " " + licznikSlowIKeyword);
        m = 0;
        /*
         while (m < licznikSlowIKeyword) {
         int k = czasID[m] - 15;
         if (k < 0) {
         k = 0;
         }
         int z = czasID[m] + 15;

         for (k = k; k <= z; k++) {
         if (bazaSlow[k] == miejsce) {
         miejsceID[licznikMiejsc] = k;
         licznikMiejsc++;
         //System.out.println(bazaSlow[k]);

         }
         }
         m++;
         }*/

        m = 0;
        while (m < licznikSlowIKeyword) {
            int k = czasID[m] - 15;
            if (k < 0) {
                k = 0;
            }
            int z = czasID[m] + 15;
            for (k = k; k <= z; k++) {

                if (startsWithUpper(database[k])) {
                    capsNazwID[licznikDuzychSlow] = k;
                    licznikDuzychSlow++;
                    //System.out.println(bazaSlow[k]);

                }
            }
            m++;
        }
        /*
         while (m < licznikDuzychSlow) {
         int k = capsNazwID[m] - 7;
         if (k < 0) {
         k = 0;
         }
         int z = capsNazwID[m] + 7;
         for (k = k; k <= z; k++) {
         System.out.println(bazaSlow[k]);
         if (bazaSlow[k] == nazwisko) {
         odpowiedzID[licznikSlowNazwisko] = k;
         licznikSlowNazwisko++;
         //  System.out.println(bazaSlow[k]);
         }
         }
            
         m++;
         }*/

        System.out.println("--------------------------");

        while (m < licznikDuzychSlow) {
            int k = capsNazwID[m] - 15;
            if (k < 0) {
                k = 0;
            }
            int z = capsNazwID[m] + 15;
            for (k = k; k <= z; k++) {
                if (found == 1) {
                    break;
                }
                if ((database[k].contains("przez") | database[k].contains("zabił") | database[k].contains("zamordował") | database[k].contains("postrzelił") | database[k].contains("zastrzelił") | database[k].contains("ukatrupił") | database[k].contains("usmiercił")) & (startsWithUpper(database[k + 1]) | startsWithUpper(database[k + 2]) | startsWithUpper(database[k + 3]) | startsWithUpper(database[k + 3]))) {
                    for (int r = 0; r < 6; r++) {
                        if (startsWithUpper(database[k + r])) {
                            System.out.print(database[k + r] + " ");
                        }
                    }
                    found = 1;
                    break;
                }
            }
            m++;
        }
        if (found == 0) {
            System.out.print("Nie znaleziono zabójcy w tekscie lub niezgadzają sie dane miejsca/osoby");
        }
        System.out.println("\n--------------------------");
        /*  for (k = k; k < z; k++) {
         if (bazaSlow[k] == nazwisko) {
         nazwCzasownikID[licznikSlowNazwisko] = k;
         licznikSlowNazwisko++;
         }
         }
         m++;
         }
         m = nazwCzasownikID[0];
         while (m <= nazwCzasownikID.length) {
         int k = m - 3;
         if (k < 0) {
         k = 0;
         }
         int z = m + 3;
         if (z > nazwCzasownikID.length) {
         z = nazwCzasownikID.length;
         }*/
    }
}
