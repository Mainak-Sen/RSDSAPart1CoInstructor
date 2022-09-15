package com.rs.dsaPart1.searching;

public class BinarySearchRecursive {

    private static int doBinarySearch(int[] input, int target, int leftBoundary, int rightBoundary) {

        //base case
        if (leftBoundary > rightBoundary) {
            return -1;
        }
        int mid = (leftBoundary + (rightBoundary - leftBoundary) / 2);

        if (input[mid] == target) {
            return mid;

        } else if (input[mid] < target) {
            return doBinarySearch(input, target, mid + 1, rightBoundary);
        } else {
            return doBinarySearch(input, target, leftBoundary, mid - 1);
        }

    }

    public static void main(String[] args) {

        int[] input = {1, 4, 5, 5, 8, 10, 32};
        System.out.println(BinarySearchRecursive.doBinarySearch(input, 5, 0, input.length - 1));

    }
}
