package com.rs.dsaPart1.searching;

public class JumpSearchAlgorithm {

    //algorithm is to search for the block where the target element could be present
    //then search linearly for the element in the block found

    private static int doJumpSearch(int[] input, int target) {

        //block size to be taken is sqrt of N i.e. length of the array
        int blockSize = (int) Math.sqrt(input.length);
        int start = 0;
        int last = blockSize - 1;

//every block is individually sorted as the input array is sorted
        while (input[last] < target && start < input.length) {

            start = last + 1; //move the start to the start of next block
            last = start + blockSize;

            //if last happens to go out of bound
            if (last > input.length - 1) {
                last = input.length - 1;
            }
        }

        //when we come out of the while loop above , we have found the block where we will do linear search for the target
        for (int i = start; i <= last; i++) {

            if (input[i] == target) {
                return i;
            }
        }

        return -1;// case when element is not found
    }

    public static void main(String[] args) {

        int[] input = {1, 4, 5, 5, 8, 10, 32};
        System.out.println(JumpSearchAlgorithm.doJumpSearch(input, 0));
    }
}
