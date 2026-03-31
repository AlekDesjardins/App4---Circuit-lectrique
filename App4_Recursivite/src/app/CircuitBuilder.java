package app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import electronique.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CircuitBuilder {

    public Composant construireCircuit(String pathIn) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode circuitBase = mapper.readTree(new File(pathIn));
        JsonNode donneesCircuit = circuitBase.get("circuit");
        return lireCircuit(donneesCircuit);
    }

    private Composant lireCircuit(JsonNode noeud) {
        if (noeud == null) {
            throw new IllegalArgumentException("Le circuit est vide");
        }
        String typeCircuit = noeud.get("type").asText();

        if ("resistance".equalsIgnoreCase(typeCircuit)) {
            return new Resistance(noeud.get("valeur").asDouble());
        } else if ("serie".equalsIgnoreCase(typeCircuit)) {
            List<Composant> circuitIntérieur = new ArrayList<>();
            for (JsonNode composantNoeud : noeud.get("composants")) {
                circuitIntérieur.add(lireCircuit(composantNoeud));
            }
            return new CircuitSerie(circuitIntérieur);
        } else if ("parallele".equalsIgnoreCase(typeCircuit)) {
            List<Composant> circuitIntérieur = new ArrayList<>();
            for (JsonNode composantNoeud : noeud.get("composants")) {
                circuitIntérieur.add(lireCircuit(composantNoeud));
            }
            return new CircuitParallele(circuitIntérieur);
        }
        throw new IllegalArgumentException("Type de circuit invalide: " + typeCircuit);
    }
}
