package app;

import electronique.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class CircuitApp {
    private static final char fSep = File.separatorChar;
    private static final String pathIn = System.getProperty("user.dir") + fSep + "App4_Recursivite" + fSep + "APP4_gr2" + fSep + "donnees" + fSep + "fichiers_json";
    private static final String pathOut = System.getProperty("user.dir") + fSep + "APP4_gr2" + fSep + "donnees" + fSep + "out.json";

    public CircuitApp() throws IOException {
        try { //PAS JUST NUMBERFORMATEXECPETION. AUSSI SI JE MET 4. Bref, gérer les exceptions.
            File monFichier = trouverFichierChoisi();
            trouverResistance(monFichier);
        } catch (NumberFormatException e) {
            System.out.println("ERREUR - Vous devez choisir un des fichiers parmi les choix\n");
            new CircuitApp();
        }

        lireAutreFichier();
    }

    public File trouverFichierChoisi() {
        Scanner lecteur = new Scanner(System.in);
        System.out.println("Voici les fichiers disponibles à analyser: \n");
        File dossierJson = new File(pathIn);
        File[] fichiersJson = dossierJson.listFiles((dir, name) -> name.endsWith(".json"));
        try {
            if (fichiersJson == null || fichiersJson.length == 0) {
                throw new IllegalArgumentException("Le fichiers de Json données est nul");
            }
            for (int compteur = 0; compteur < fichiersJson.length; compteur++) {
                System.out.println("Choix " + (compteur + 1) + ": " + fichiersJson[compteur].getName());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nVotre choix: ");
        String entree = lecteur.nextLine();
        System.out.println("\nVeuillez patientez...\n");
        int numeroFichier = Integer.parseInt(entree) - 1;
        File fichierChoisi = fichiersJson[numeroFichier];
        return fichierChoisi;
    }

    public void trouverResistance(File fichierChoisi) throws IOException {
        CircuitBuilder builder = new CircuitBuilder();
        Composant circuit = builder.construireCircuit(pathIn + fSep + fichierChoisi.getName());
        double resistance = circuit.calculerResistance();
        System.out.println("La résistance de ce circuit est " + (Math.round(resistance * 100.0) / 100.0) + " " + 'Ω');
    }

    public void lireAutreFichier() throws IOException {
        Scanner lecteur1 = new Scanner(System.in);
        System.out.println("\nVoulez-vous lire un autre fichier?\n Oui [O]\t Non[N]");
        String entree1 = lecteur1.nextLine();
        if (!(entree1.equalsIgnoreCase("n") || entree1.equalsIgnoreCase("o"))) {
            System.out.println("Cette réponse est invalide.");
            lireAutreFichier();
        } else if (entree1.equalsIgnoreCase("O")) {
            new CircuitApp();
        }
    }


    public static void main(String[] args) throws IOException {
        new CircuitApp();
    }

}
