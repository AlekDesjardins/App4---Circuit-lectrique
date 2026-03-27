package electronique;

import java.util.List;

public class CircuitSerie extends Circuit{

    public CircuitSerie(List<Composant> composants) {
        setComposants(composants);
    }
    public void setComposants(List<Composant> composants){
        this.composants = composants;
    }
}
