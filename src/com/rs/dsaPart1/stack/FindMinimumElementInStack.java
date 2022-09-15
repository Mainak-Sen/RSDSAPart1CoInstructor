package com.rs.dsaPart1.stack;

import java.util.Stack;

public class FindMinimumElementInStack {

    //algorithm
    //while pushing new elements maintain a temporary stack to push the new element into it only when it's lesser than previous min
    //while popping elements from original stack , if that happens to be the min element(derived from peek()) ,pop that too from aux stack

    public static Stack<Integer> originalStack = new Stack<>();
    public static Stack<Integer> auxiliaryStack = new Stack<>();

    public static void customPush(int value) {

        originalStack.push(value);
        if (auxiliaryStack.isEmpty() || auxiliaryStack.peek() > value) {
            auxiliaryStack.push(value);
        }
    }

    public static void customPop() {

        //store the value to be popped in a temporary variable so that it can be used in the next step
        int valuePopped = originalStack.pop();
        if (auxiliaryStack.peek() == valuePopped) {
            auxiliaryStack.pop();
        }
    }

    public static int minElement() {

        if (auxiliaryStack.isEmpty()) {
            throw new RuntimeException("Stack is empty ,so no min element found!!!");
        } else {
            return auxiliaryStack.peek();
        }
    }


    public static void main(String[] args) {

        customPush(40);
        customPush(30);
        customPop();
        customPush(19);
        customPop();
        customPush(10);
        customPush(5);
        customPop();
        customPush(1);
        customPop();


        System.out.println("The current minimum element in the stack is : " + minElement());

    }
}
