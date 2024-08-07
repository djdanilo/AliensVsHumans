package App;

import java.util.HashMap;

public class Translators {

    private HashMap<String, TranslatorObjects> translators = new HashMap<>();
    private String[] speciesList = {"human", "grey", "zurg", "xenomorph", "babyXenomorph"};
    private int numSpecies;

    public Translators() {
        this.numSpecies = getNumSpecies();
        this.setTranslationHashMap();
    }

    private int getNumSpecies() {
        int counter = 0;
        for (String species : speciesList) {
            counter += 1;
        }
        return counter;
    }

    private void setTranslationHashMap() {
        for (int i = 0; i < numSpecies; i++) {
            this.translators.put(speciesList[i], TranslatorObjects.values()[i]);
        }
    }

    public HashMap<String, TranslatorObjects> getTranslationHashMap() {
        return this.translators;
    }
}
