package app;

import electronique.CircuitSerie;
import electronique.Composant;
import electronique.Resistance;

import java.util.ArrayList;
import java.util.List;

public class CircuitApp {

    public static void main(String[] args) {
        Resistance res = new Resistance(5);
        Resistance res1 = new Resistance(2);
        Resistance res2 = new Resistance(1);
        List<Composant> yo = new ArrayList<>();
        yo.add(res);
        yo.add(res1);
        yo.add(res2);
        CircuitSerie y = new CircuitSerie(yo);
        System.out.println(y.calculerResistance());
        yo.add(y);
        CircuitSerie loi = new CircuitSerie(yo);
        System.out.println(loi.calculerResistance());
    }
}
