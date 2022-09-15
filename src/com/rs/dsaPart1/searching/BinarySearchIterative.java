package com.rs.dsaPart1.searching;

public class BinarySearchIterative {

    private static int doBinarySearch(int[] input, int target) {

        int leftBoundary = 0;
        int rightBoundary = input.length - 1;

        while (leftBoundary <= rightBoundary) {
            int mid = (leftBoundary + (rightBoundary - leftBoundary) / 2);

            if (input[mid] == target) {
                return mid;
            } else if (input[mid] < target) {
                leftBoundary = mid + 1;
            } else {
                rightBoundary = mid - 1;
            }
        }

        //if we end up here that means the target element is not found
        return -1;
    }

    public static void main(String[] args) {

        int[] input = {1, 4, 5, 5, 8, 10, 32};
        System.out.println(BinarySearchIterative.doBinarySearch(input, 0));
    }

}
