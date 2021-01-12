package pl.put.poznan.transformer.test;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.InputString;
import pl.put.poznan.transformer.logic.ToCapital;

import static org.junit.jupiter.api.Assertions.*;

class ToLowerTest {

    @Test
    public void transform() {
        String s = "ABC";
        InputString inputString = new InputString(s);
        ToCapital r = new ToCapital(inputString);

        assertEquals("abc", r.transform(), "ToLower");
    }

}