package com.rs.dsaPart1.sorting;

import java.util.Arrays;

public class MergeSort {

    private static void merge_sort(int[] input) {

        //base case
        if (input.length <= 1) {
            return;
        }

        int middle = input.length / 2;
        //left array
        int[] leftArray = new int[middle];
        //right array
        int[] rightArray = new int[input.length - middle];

        //feed left array
        for (int i = 0; i < middle; i++) {
            leftArray[i] = input[i];
        }

        //feed right array
        for (int i = middle; i < input.length; i++) {
            rightArray[i - middle] = input[i];
        }

        merge_sort(leftArray);
        merge_sort(rightArray);
        merge(leftArray, rightArray, input);


    }

    private static void merge(int[] leftArray, int[] rightArray, int[] input) {

        int i = 0, j = 0, k = 0;
        //i pointing left array, j pointing right array and k the temporary merged array
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                input[k++] = leftArray[i++];
            } else {
                input[k++] = rightArray[j++];
            }
        }

        //handle case when either of left or right array finishes
        while (i < leftArray.length) {
            input[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            input[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {

        int[] input = new int[]{4, 3, 89, 4, 6, 2, 1, 0, 4, 65};
        merge_sort(input);
        System.out.println(Arrays.toString(input));
    }
}
