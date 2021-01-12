package pl.put.poznan.transformer.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class ToLowerTest {

    @Test
    public void transform() {
        String s = "ABC";
        InputString inputString = new InputString(s);
        ToCapital r = new ToCapital(inputString);

        assertEquals("abc", r.transform(), "ToLower");
    }

    @Test
    public void toLowerMockTest1() throws Exception {
        IText mockObject = mock(IText.class);
        when(mockObject.transform()).thenReturn("TEXT");
        ToLower testedObject = new ToLower(mockObject);
        String result = testedObject.transform();
        verify(mockObject).transform();
        Assert.assertEquals("text", result);
    }

    @Test
    public void reverseMockTest2() throws Exception {
        IText mockObject = mock(IText.class);
        when(mockObject.transform()).thenReturn("SAMple");
        ToLower testedObject = new ToLower(mockObject);
        String result = testedObject.transform();
        verify(mockObject).transform();
        Assert.assertEquals("sample", result);
    }
}