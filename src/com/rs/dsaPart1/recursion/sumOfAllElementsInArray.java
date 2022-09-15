package com.rs.dsaPart1.recursion;

public class sumOfAllElementsInArray {

    public static int recursivelyFindSumOfAllElementsInArray(int[] input, int uptoIndex) {

        //base case
        if (uptoIndex == 0) {
            return input[0];

        } else {
            return input[uptoIndex] + recursivelyFindSumOfAllElementsInArray(input, uptoIndex - 1);
        }

    }


    public static void main(String[] args) {

        int[] input = {5, 7, 4, 0, -9, 2, 10};
        System.out.println(recursivelyFindSumOfAllElementsInArray(input, input.length - 2));
    }

}
