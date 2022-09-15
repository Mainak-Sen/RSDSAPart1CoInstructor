package com.rs.dsaPart1.stack;

import java.util.Stack;

public class insertElementAtGivenIndex {

    //the algorithm will be
    //1. push the elements from given stack to an auxiliary stack until we reach the index where we want to insert new element
    //2. push the new element into the stack
    //3. push the elements from the auxiliary stack to the given stack (since after we moved to auxiliary stack it got reversed
    // ,and again it got reversed back to what it was before when we pushed back from auxiliary to original given stack


    public static void insertElementAtAGivenIndexInStack(Stack<Integer> stack, int value, int index) {

        //when index specified is out of bounds
        if (index > stack.size()) {
            throw new RuntimeException("Index specified to insert the element is invalid");
        }
        //create an auxiliary stack
        Stack<Integer> auxiliaryStack = new Stack<>();
        //remove elements from original stack to auxiliaryStack until we reach the index where we want to push the new element
        int count = 0;
        int originalStackSize = stack.size();
        while (count < (originalStackSize - index)) {
            auxiliaryStack.push(stack.pop());
            count++;
        }

        //push the required element
        stack.push(value);

        //push the elements from auxiliary stack back to original stack
        while (!auxiliaryStack.isEmpty()) {
            stack.push(auxiliaryStack.pop());
        }

    }


    public static void main(String[] args) {

        Stack<Integer> originalStack = new Stack<>();
        originalStack.push(25);
        originalStack.push(36);
        originalStack.push(65);
        originalStack.push(43);
        originalStack.push(19);
        originalStack.push(71);
        originalStack.push(84);
        originalStack.push(100);

        System.out.println("the original stack before inserting the element at given index is: " + originalStack);
        //insert operation
        insertElementAtAGivenIndexInStack(originalStack, 62, 12);
        System.out.println("************************************************************************************");
        //print the output
        System.out.println("the original stack after inserting the element at given index is: " + originalStack);

    }
}
