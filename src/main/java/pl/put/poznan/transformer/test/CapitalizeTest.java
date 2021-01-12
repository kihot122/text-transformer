package pl.put.poznan.transformer.test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapitalizeTest {

    @Test
    public String transform() {
        String s = "abc";

        CapitalizeTest tester = new CapitalizeTest();

        assertEquals("Abc", tester.transform(), "Capitalize");

        return "";
    }
}