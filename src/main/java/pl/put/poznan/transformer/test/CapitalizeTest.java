package pl.put.poznan.transformer.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.Capitalize;
import pl.put.poznan.transformer.logic.IText;
import pl.put.poznan.transformer.logic.InputString;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CapitalizeTest {

    @Test
    public void transform() {
        String s = "abc";
        InputString inputString = new InputString(s);
        Capitalize c = new Capitalize(inputString);

        assertEquals("Abc", c.transform(), "Capitalize");
    }

    @Test
    public void capitalizeTestMock1() throws Exception {
        IText mockObject = mock(IText.class);
        when(mockObject.transform()).thenReturn("sample text");
        Capitalize testedObject = new Capitalize(mockObject);
        String result = testedObject.transform();
        verify(mockObject).transform();
        Assert.assertEquals("Sample text", result);

    }
    @Test
    public void capitalizeTestMock2() throws Exception {
        IText mockObject = mock(IText.class);
        when(mockObject.transform()).thenReturn("text sample");
        Capitalize testedObject = new Capitalize(mockObject);
        String result = testedObject.transform();
        verify(mockObject).transform();
        Assert.assertEquals("Text sample", result);

    }
}

