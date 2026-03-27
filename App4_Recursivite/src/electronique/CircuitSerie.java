package electronique;

import java.util.ArrayList;
import java.util.List;

public class CircuitSerie extends Circuit {

    public CircuitSerie(List<Composant> composants) {
        super(composants);

    }

    @Override
    public double calculerResistance() {
        double resistance = 0;
        for (int compteur = 0; compteur < this.composants.size(); compteur++) {
           resistance += this.composants.get(compteur).calculerResistance();
        }
        return resistance;
    }

}
