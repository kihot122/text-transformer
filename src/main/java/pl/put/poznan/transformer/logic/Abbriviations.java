package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

public class Abbriviations {


    private Map<String, String> abbriviations;
    public Map<String, String> getAbbriviations() {
        return abbriviations;
    }

    public Abbriviations(){
        abbriviations = new HashMap<>();

        abbriviations.put("mgr", "magister");
        abbriviations.put("Mgr", "Magister");
        abbriviations.put("MGR", "MAGISTER");

        abbriviations.put("dr", "doktor");
        abbriviations.put("Dr", "Doktor");
        abbriviations.put("DR", "DOKTOR");

        abbriviations.put("np.", "na przykład");
        abbriviations.put("Np.", "Na przykład");
        abbriviations.put("NP.", "NA PRZYKŁAD");

        abbriviations.put("prof.", "profesor");
        abbriviations.put("Prof.", "Profesor");
        abbriviations.put("PROF..", "PROFESOR");

        abbriviations.put("inż.", "inżynier");
        abbriviations.put("Inż.", "Inżynier");
        abbriviations.put("INŻ.", "INŻYNIER");

        abbriviations.put("hab.", "habilitowany");
        abbriviations.put("Hab.", "Habilitowany");
        abbriviations.put("HAB.", "HABILITOWANY");

        abbriviations.put("itp.", "i tym podobne");
        abbriviations.put("Itp.", "I tym podobne");
        abbriviations.put("ITP.", "I TYM PODOBNE");
    }

}
