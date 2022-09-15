package com.rs.dsaPart1.stack;

import java.util.Stack;

public class SortElementsInAGivenStack {

    private static Stack<Integer> stackSort(Stack<Integer> inputStack) {

        //create an auxiliaryStack
        Stack<Integer> auxiliaryStack = new Stack<>();

        while (!inputStack.isEmpty()) {
            int valuePoppedFromInputStack = inputStack.pop();
            while (!auxiliaryStack.isEmpty() && auxiliaryStack.peek() > valuePoppedFromInputStack) {
                //adjust to position the value popped at the correct sorted place in the auxiliary stack
                int auxStackTop = auxiliaryStack.pop();
                inputStack.push(auxStackTop);
                //this way all the elements from auxiliary stack which are greater than valuePoppedFromInputStack moves to input stack
                //,to be compared later again
            }
            auxiliaryStack.push(valuePoppedFromInputStack);
        }

        //when we come here we have the auxiliary stack sorted as expected
        return auxiliaryStack;
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
        originalStack.push(36);
        originalStack.push(100);

        System.out.println("The stack before sorting : " + originalStack);

        System.out.println("********************************************************************************************");

        System.out.println("The stack after sorting: " + stackSort(originalStack));

    }
}
