package app;

import electronique.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class CircuitApp {
    private static final char fSep = File.separatorChar;
    private static final String pathIn = System.getProperty("user.dir") + fSep + "App4_Recursivite" + fSep + "src" + fSep + "donnees" + fSep + "fichiers_json";

    public CircuitApp() throws IOException {
        try {
            File monFichier = trouverFichierChoisi();
            trouverResistance(monFichier);
        } catch (IllegalArgumentException e) {
            System.out.println("ERREUR - " + e.getMessage() + "\n");
            new CircuitApp();
        }
        lireAutreFichier();
    }

    public File trouverFichierChoisi() {
        Scanner lecteur = new Scanner(System.in);
        System.out.println("Voici les fichiers disponibles à analyser: \n");
        File dossierJson = new File(pathIn);
        File[] fichiersJson = dossierJson.listFiles((dir, name) -> name.endsWith(".json"));

        if (fichiersJson == null || fichiersJson.length == 0) {
            throw new IllegalArgumentException("Le fichiers de Json données est nul");
        }
        for (int compteur = 0; compteur < fichiersJson.length; compteur++) {
            System.out.println("Choix " + (compteur + 1) + ": " + fichiersJson[compteur].getName());
        }

        System.out.println("\nVotre choix: ");
        String entree = lecteur.nextLine();


        File fichierChoisi;
        try {
            int numeroFichier = Integer.parseInt(entree) - 1;
            fichierChoisi = fichiersJson[numeroFichier];
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException("Vous devez choisir un des fichiers disponibles");
        }
        return fichierChoisi;
    }

    public void trouverResistance(File fichierChoisi) throws IOException {
        CircuitBuilder builder = new CircuitBuilder();
        Composant circuit = builder.construireCircuit(pathIn + fSep + fichierChoisi.getName());
        System.out.println("\nVeuillez patientez...\n");
        double resistance = circuit.calculerResistance();
        System.out.println("La résistance de ce circuit est " + (Math.round(resistance * 100.0) / 100.0) + " " + 'Ω');
    }

    public void lireAutreFichier() throws IOException {
        Scanner lecteur1 = new Scanner(System.in);
        System.out.println("\nVoulez-vous lire un autre fichier?\n Oui [O]\t Non [N]");
        String entree1 = lecteur1.nextLine();
        if (!(entree1.equalsIgnoreCase("n") || entree1.equalsIgnoreCase("o"))) {
            System.out.println("Cette réponse est invalide.");
            lireAutreFichier();
        } else if (entree1.equalsIgnoreCase("O")) {
            new CircuitApp();
        }
        System.out.println("\nMerci d'avoir utilisé le code de Alek Desjardins!");
        System.exit(0);

    }


    public static void main(String[] args) throws IOException {
        new CircuitApp();

    }

}
