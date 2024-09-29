package com.tests;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayFlattenerTest.class
})
public class ArrayFlattenerTest {

    private ArrayFlattener arrayFlattener = new ArrayFlattener();


    @Test
    public void testFlattenArrayLegitInput() {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] expectedOutput = {1, 3, 0, 4, 5, 9};


        int[] actualOutput = arrayFlattener.flattenArray(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testFlattenArrayNullInput() {
        int[][] input = null;

        int[] actualOutput = arrayFlattener.flattenArray(input);
        assertNull(actualOutput);
    }
}
