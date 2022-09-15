package com.rs.dsaPart1.sorting;

import java.util.Arrays;

public class BubbleSort {

    private static void implementBubbleSort(int[] input) {

        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length - i; j++) {
                //swap
                if (input[j] < input[j - 1]) {
                    swap(j, j - 1, input);
                }
            }
        }

        System.out.println(Arrays.toString(input));
    }

    private static void swap(int index1, int index2, int[] input) {

        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }

    public static void main(String[] args) {

        int[] input = {4, 8, 3, 9, 2, 6, 3, 7};
        implementBubbleSort(input);
    }
}
