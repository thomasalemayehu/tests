package com.tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayReversorTest {

    private ArrayFlattenerService flattenerService;
    private ArrayReversor arrayReversor;

    @Before
    public void setUp() {

        flattenerService = Mockito.mock(ArrayFlattenerService.class);


        arrayReversor = new ArrayReversor(flattenerService);
    }


    @Test
    public void testReverseArrayLegitInput() {

        int[][] input = {{1, 3}, {0}, {4, 5, 9}};

        when(flattenerService.flattenArray(input)).thenReturn(new int[]{1, 3, 0, 4, 5, 9});


        int[] expectedOutput = {9, 5, 4, 0, 3, 1};


        int[] actualOutput = arrayReversor.reverseArray(input);


        assertArrayEquals(expectedOutput, actualOutput);

        verify(flattenerService).flattenArray(input);
    }


    @Test
    public void testReverseArrayNullInput() {
        int[][] input = null;


        when(flattenerService.flattenArray(input)).thenReturn(null);


        assertNull(arrayReversor.reverseArray(input));

        verify(flattenerService).flattenArray(input);
    }
}
