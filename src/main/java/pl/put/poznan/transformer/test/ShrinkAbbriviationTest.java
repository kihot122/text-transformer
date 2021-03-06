package pl.put.poznan.transformer.test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.InputString;
import pl.put.poznan.transformer.logic.ToCapital;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShrinkAbbriviationTest {

    @Test
    public void transform(){
        String s = "magister";
        InputString inputString = new InputString(s);
        ToCapital r = new ToCapital(inputString);

        assertEquals("mgr", r.transform(), "Shrink");
    }
}