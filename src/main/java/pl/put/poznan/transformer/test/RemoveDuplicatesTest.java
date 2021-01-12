package pl.put.poznan.transformer.test;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.InputString;
import pl.put.poznan.transformer.logic.RemoveDuplicates;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    @Test
    public void transform() {
        String s = "abc abc";
        InputString inputString = new InputString(s);
        RemoveDuplicates r = new RemoveDuplicates(inputString);

        assertEquals("abc", r.transform(), "RemoveDuplicates");
    }
}