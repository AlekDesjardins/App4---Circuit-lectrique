package electronique;

import java.util.List;

public class CircuitParallele extends Circuit{

    public CircuitParallele(List<Composant> composants) {
         setComposants(composants);
    }
    public void setComposants(List<Composant> composants){
        this.composants = composants;
    }
}
