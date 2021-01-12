package pl.put.poznan.transformer.test;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.Capitalize;
import pl.put.poznan.transformer.logic.InputString;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapitalizeTest {

    @Test
    public void transform() {
        String s = "abc";
        InputString inputString = new InputString(s);
        Capitalize c = new Capitalize(inputString);

        assertEquals("Abc", c.transform(), "Capitalize");
    }
}