package com.rs.dsaPart1.sorting;

import java.util.Arrays;

public class SelectionSort {

    private static void implementSelectionSort(int[] input) {

        //the algorithm is to select the min element in every iteration and push it to the left
        for (int i = 0; i < input.length; i++) {
            //considering the current element as min
            int min = i;
            for (int j = i; j < input.length; j++) {
                if (input[j] < input[min]) {
                    //to find the smallest number in the iteration
                    min = j;
                }
            }
            //we have found the smallest number in the last iteration
            //lets move it to the left
            //swap
            swap(i, min, input);
        }

        System.out.println(Arrays.toString(input));
    }

    private static void swap(int index1, int index2, int[] input) {

        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }

    public static void main(String[] args) {

        //int[] input = {4, 8, 3, 9, 2, 6, 3, 7};
        int[] input = {1, 1, 5, 1, 4, 1, 2, 1};
        implementSelectionSort(input);
    }
}
