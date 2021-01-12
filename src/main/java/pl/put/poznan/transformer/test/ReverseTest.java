package pl.put.poznan.transformer.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.IText;
import pl.put.poznan.transformer.logic.InputString;
import pl.put.poznan.transformer.logic.RemoveDuplicates;
import pl.put.poznan.transformer.logic.Reverse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReverseTest {

    @Test
    public void transform() {
        String s = "abc";
        InputString inputString = new InputString(s);
        Reverse r = new Reverse(inputString);

        assertEquals("cba", r.transform(), "Reverse");
    }

    @Test
    public void reverseMockTest1() throws Exception {
        IText mockObject = mock(IText.class);
        when(mockObject.transform()).thenReturn("sample");
        Reverse testedObject = new Reverse(mockObject);
        String result = testedObject.transform();
        verify(mockObject).transform();
        Assert.assertEquals("elpmas", result);
    }

    @Test
    public void reverseMockTest2() throws Exception {
        IText mockObject = mock(IText.class);
        when(mockObject.transform()).thenReturn("text");
        Reverse testedObject = new Reverse(mockObject);
        String result = testedObject.transform();
        verify(mockObject).transform();
        Assert.assertEquals("txet", result);
    }
}

