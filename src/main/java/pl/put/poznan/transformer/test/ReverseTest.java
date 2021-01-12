package pl.put.poznan.transformer.test;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.InputString;
import pl.put.poznan.transformer.logic.Reverse;

import static org.junit.jupiter.api.Assertions.*;

class ReverseTest {

    @Test
    public void transform() {
        String s = "abc";
        InputString inputString = new InputString(s);
        Reverse r = new Reverse(inputString);

        assertEquals("cba", r.transform(), "Reverse");
    }

}