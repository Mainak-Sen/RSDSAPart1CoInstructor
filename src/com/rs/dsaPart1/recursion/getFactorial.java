package com.rs.dsaPart1.recursion;

public class getFactorial {

    public static int getFactorialRecursive(int n) {

        //base case
        if (n <= 1) {
            return 1;
        } else {
            return n * getFactorialRecursive(n - 1);
        }

    }

    public static void main(String[] args) {

        System.out.println(getFactorialRecursive(5));
    }
}
