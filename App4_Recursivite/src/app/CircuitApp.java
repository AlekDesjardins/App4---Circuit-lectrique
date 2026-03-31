package app;

import electronique.*;

import java.io.File;
import java.util.List;
import java.util.Scanner;


public class CircuitApp {
    private static final char fSep = File.separatorChar;
    private static final String pathIn1 = System.getProperty("user.dir") + fSep + "APP4_gr2" + fSep + "donnees" + fSep + "fichiers_json" + fSep + "complexe_industriel_zone_nord.json";
    private static final String pathIn2 = System.getProperty("user.dir") + fSep + "APP4_gr2" + fSep + "donnees" + fSep + "fichiers_json" + fSep + "eclairage_public_quartier.json";
    private static final String pathIn3 = System.getProperty("user.dir") + fSep + "APP4_gr2" + fSep + "donnees" + fSep + "fichiers_json" + fSep + "reseau_secours_hopital.json";
    private static final String pathOut = System.getProperty("user.dir") + fSep + "APP4_gr2" + fSep + "donnees" + fSep + "out.json";

    public CircuitApp() {
        Scanner lecteur = new Scanner(System.in);
        System.out.println("Bonjour! Voici les fichiers disponibles à analyser: \n");
        System.out.println("[1] " + pathIn1.substring(69));
        System.out.println("[2] " + pathIn2.substring(69));
        System.out.println("[3] " + pathIn3.substring(69));
        String entree = lecteur.nextLine();
        System.out.println("Veuillez patientez...");
        if (Integer.parseInt(entree) == 1){
            Composant monCircuit = ;
                  monCircuit.construireCircuit(pathIn1);
        }
    }


    public static void main(String[] args) {
        new CircuitApp();
    }

}
