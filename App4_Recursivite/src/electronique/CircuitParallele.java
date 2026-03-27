package electronique;

import java.util.ArrayList;
import java.util.List;

public class CircuitParallele extends Circuit {

    public CircuitParallele(List<Composant> composants) {
        super(composants);
    }

    @Override
    public double calculerResistance() {
        double resistance = 0;
        for (int compteur = 0; compteur < this.composants.size(); compteur++) {
            resistance += 1/ this.composants.get(compteur).calculerResistance();
        }
        return 1/resistance;
    }
}

