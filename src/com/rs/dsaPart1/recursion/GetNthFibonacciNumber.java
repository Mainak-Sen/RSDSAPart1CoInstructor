package com.rs.dsaPart1.recursion;

public class GetNthFibonacciNumber {

    public static int getNthFibonacciNumberRecursive(int n) {

        //base case
        if (n <= 1) {
            return n;
        }

        return getNthFibonacciNumberRecursive(n - 1) + getNthFibonacciNumberRecursive(n - 2);


    }

    public static void main(String[] args) {

        System.out.println(getNthFibonacciNumberRecursive(8)); //time complexity is exponential for the above ,can be optimised using dynamic programming
    }
}
