package electronique;

import java.util.ArrayList;
import java.util.List;

public class CircuitSerie extends Circuit {

    public CircuitSerie(List<Composant> composants) {
        super(composants);

    }

    public double calculerResistance() {
        double resistance = 0;
        for (int compteur = 0; compteur < this.composants.size(); compteur++) {
            Composant MonComposant = this.composants.get(compteur);
            if (MonComposant.getClass().getSimpleName().equals("CircuitSerie")) {
                List<Composant> CircuitSerie = new ArrayList<>();
                CircuitSerie.add(MonComposant);
                MonComposant = new CircuitSerie(CircuitSerie);
                double resistanceTemporaire = MonComposant.calculerResistance();
                resistance += resistanceTemporaire;
            } else if (MonComposant.getClass().getSimpleName().equals("CircuitParallele")) {
                List<Composant> CircuitParallele = new ArrayList<>();
                CircuitParallele.add(MonComposant);
                MonComposant = new CircuitParallele(CircuitParallele);
                double resistanceTemporaire = MonComposant.calculerResistance();
                resistance += resistanceTemporaire;
            } else if (MonComposant.getClass().getSimpleName().equals("Resistance")) {
                double resistanceTemporaire = MonComposant.calculerResistance();
                resistance += resistanceTemporaire;
            }

        }
        return resistance;
    }
}
