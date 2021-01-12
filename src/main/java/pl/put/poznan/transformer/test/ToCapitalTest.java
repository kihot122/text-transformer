package pl.put.poznan.transformer.test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pl.put.poznan.transformer.logic.InputString;
import pl.put.poznan.transformer.logic.ToCapital;

class ToCapitalTest {

    @Test
    public void transform() {
        String s = "abc";
        InputString inputString = new InputString(s);
        ToCapital r = new ToCapital(inputString);

        assertEquals("ABC", r.transform(), "ToCapital");
    }

}