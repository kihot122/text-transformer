package pl.put.poznan.transformer.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import pl.put.poznan.transformer.logic.IText;
import pl.put.poznan.transformer.logic.InputString;
import pl.put.poznan.transformer.logic.ToCapital;
import pl.put.poznan.transformer.logic.ToLower;

class ToCapitalTest {

    @Test
    public void transform() {
        String s = "abc";
        InputString inputString = new InputString(s);
        ToCapital r = new ToCapital(inputString);

        assertEquals("ABC", r.transform(), "ToCapital");
    }

    @Test
    public void toCapitalTest1() throws Exception {
        IText mockObject = mock(IText.class);
        when(mockObject.transform()).thenReturn("text");
        ToCapital testedObject = new ToCapital(mockObject);
        String result = testedObject.transform();
        verify(mockObject).transform();
        Assert.assertEquals("TEXT", result);
    }

    @Test
    public void toCapitalTest2() throws Exception {
        IText mockObject = mock(IText.class);
        when(mockObject.transform()).thenReturn("sample");
        ToCapital testedObject = new ToCapital(mockObject);
        String result = testedObject.transform();
        verify(mockObject).transform();
        Assert.assertEquals("SAMPLE", result);
    }
}