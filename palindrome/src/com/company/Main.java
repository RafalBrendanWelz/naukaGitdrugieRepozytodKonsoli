package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static char[] tekstOdwrocony;

    public static void main(String[] args) {
        System.out.println("Witamy w programie z palindromami");

        String tekstWpisany = wpiszTekst();

        tekstOdwrocony = odwrocTekst(tekstWpisany);

        wypiszOdpowiedz(czyPalindrom(tekstWpisany, tekstOdwrocony), tekstWpisany, tekstOdwrocony);
    }

    private static void wypiszOdpowiedz(boolean czyPalindrom, String tekstWpisany, char[] tekstOdwrocony) {
        System.out.println("Twój tekst to [" + tekstWpisany + "]");
        System.out.print("Tekst odwrotny do niego to [");
                    wypiszTabliceChar(tekstOdwrocony);
        System.out.println("]");

        if (czyPalindrom){
            System.out.println("I on jest palindromem");
        }else {
            System.out.println("Nie jest palindromem");
        }
    }

    private static void wypiszTabliceChar(char[] tekstOdwrocony) {
        for (int i = 0; i < tekstOdwrocony.length; i++) {
            System.out.print(tekstOdwrocony[i]);
        }
    }

    private static boolean czyPalindrom(String tekstWpisany, char[] tekstOdwrocony) {
        boolean jestPalindrom = true;

        for (int i = 0; i < tekstWpisany.length(); i++) {
            if (tekstOdwrocony[i] != tekstWpisany.charAt(i) ){
                jestPalindrom = false;
                break;
            }

        }

        return jestPalindrom;
    }

    private static char[] odwrocTekst(String tekstWpisany) {
        char odwracana;
        tekstOdwrocony = tekstWpisany.toCharArray();

        for (int i = 0; i < tekstWpisany.length() /2; i++) {
            odwracana = tekstWpisany.charAt(i);

            tekstOdwrocony[tekstWpisany.length() - i - 1] = odwracana;

            tekstOdwrocony[i] = tekstWpisany.charAt(tekstWpisany.length() - i - 1);
        }

        return tekstOdwrocony;
    }

    private static String wpiszTekst(){
        Scanner wpisuj = new Scanner(System.in);
        System.out.println("Wpisz tekst");

        return normalizacja(wpisuj.nextLine());
    }

    private static String normalizacja(String nextLine) {
        nextLine = nextLine.toUpperCase().trim();
        nextLine = nextLine.replace(" ", "");   //łatwiejszy sposób usuwania spacji przez zamienianie wszystkich znaków
                                                                    //z tekstu na jakiś inny (powinno być pusty)

        return nextLine;
    }



}
