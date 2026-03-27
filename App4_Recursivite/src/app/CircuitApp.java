package app;

import electronique.CircuitParallele;
import electronique.CircuitSerie;
import electronique.Composant;
import electronique.Resistance;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CircuitApp {

    public static void main(String[] args) {
        Resistance res = new Resistance(5);
        Resistance res1 = new Resistance(2);
        Resistance res2 = new Resistance(1);
        List<Composant> composants1 = List.of(res, res1, res2);
        CircuitParallele parallele = new CircuitParallele(composants1);
        List<Composant> composants2 = List.of(res, parallele);
        CircuitSerie serie = new CircuitSerie(composants2);
        System.out.println(serie.calculerResistance());

        Scanner lecteur = new Scanner(System.in);
        System.out.println("Bonjour! Voici les fichiers disponibles à analyser: \n");
        //Énumération
        String entree = lecteur.nextLine();


    }

}
