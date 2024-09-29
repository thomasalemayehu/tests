package com.tests;

public class ArrayFlattener {

    // Method to flatten a 2D array into a 1D array
    public int[] flattenArray(int[][] array) {
        if (array == null) {
            return null;  // Handle null input
        }

        // First, calculate the size of the flattened array
        int totalElements = 0;
        for (int[] subArray : array) {
            if (subArray != null) {
                totalElements += subArray.length;
            }
        }

        // Create a new 1D array to hold the flattened elements
        int[] flatArray = new int[totalElements];
        int index = 0;

        // Flatten the 2D array
        for (int[] subArray : array) {
            if (subArray != null) {
                for (int element : subArray) {
                    flatArray[index++] = element;
                }
            }
        }

        return flatArray;
    }
}
