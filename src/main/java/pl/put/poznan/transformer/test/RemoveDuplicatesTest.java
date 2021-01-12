package pl.put.poznan.transformer.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.Capitalize;
import pl.put.poznan.transformer.logic.IText;
import pl.put.poznan.transformer.logic.InputString;
import pl.put.poznan.transformer.logic.RemoveDuplicates;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RemoveDuplicatesTest {

    @Test
    public void transform() {
        String s = "abc abc";
        InputString inputString = new InputString(s);
        RemoveDuplicates r = new RemoveDuplicates(inputString);

        assertEquals("abc", r.transform(), "RemoveDuplicates");
    }

    @Test
    public void removeDublicatesMockTest1() throws Exception {
        IText mockObject = mock(IText.class);
        when(mockObject.transform()).thenReturn("text text");
        RemoveDuplicates testedObject = new RemoveDuplicates(mockObject);
        String result = testedObject.transform();
        verify(mockObject).transform();
        Assert.assertEquals("text", result);

    }

    @Test
    public void removeDublicatesMockTest2() throws Exception {
        IText mockObject = mock(IText.class);
        when(mockObject.transform()).thenReturn("sample sample");
        RemoveDuplicates testedObject = new RemoveDuplicates(mockObject);
        String result = testedObject.transform();
        verify(mockObject).transform();
        Assert.assertEquals("sample", result);


    }
}