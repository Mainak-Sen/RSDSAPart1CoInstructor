package com.rs.dsaPart1.stack;

import java.util.Stack;

public class ReverseContentsOfAStack {

    //basically the algorithm would be
    // 1.to move the contents of stack 1 to stack 2
    //2. move the contents of stack2 to stack 3
    //3. move the contents of stack 3 to stack 1

    private static void moveContentsFromSourceStackToDestinationStack(Stack<Integer> source, Stack<Integer> destination) {

        while (!source.isEmpty()) {
            destination.push(source.pop());
        }

    }


    public static void main(String[] args) {

        Stack<Integer> stack1 = new Stack<>();
        stack1.push(25);
        stack1.push(36);
        stack1.push(65);
        stack1.push(43);
        stack1.push(19);

        System.out.println("Contents of stack before reversing: " + stack1);


        //create two auxiliary stacks more for the purpose of the algorithm
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        //operations to be performed as per algorithm
        //1.
        moveContentsFromSourceStackToDestinationStack(stack1, stack2);
        //2.
        moveContentsFromSourceStackToDestinationStack(stack2, stack3);
        //3.
        moveContentsFromSourceStackToDestinationStack(stack3, stack1);

        System.out.println("**************************************************");
        System.out.println("Contents of stack after reversing: " + stack1);

    }

}
