package com.rs.dsaPart1.queue;

import java.util.Stack;

public class ImplementEnqueueDequeueUsingStack {

    private static Stack<Integer> stackImplementationOfQueue = new Stack<>();

    //implement enqueue ,enqueue new element at the end ,this will be similar to push operation of stack
    private void enqueue(int x) {
        stackImplementationOfQueue.push(x);
    }

    //implement dequeue, dequeue an element from the front (FIFO mechanism),
    //this we will implement with an auxiliary stack
    private int dequeue() {

        Stack<Integer> auxiliaryStack = new Stack<>();
        //push all the elements from the stackImplementationOfQueue to the auxiliary stack until there is only 1 element
        while (stackImplementationOfQueue.size() != 1) {
            auxiliaryStack.push(stackImplementationOfQueue.pop());
        }
        //remove the element remaining in the stackImplementationOfQueue i.e. dequeue element from front by FIFO mechanism
        int dequeuedElement = stackImplementationOfQueue.pop();
        //push back the remaining elements from auxiliary stack to the original stack i.e. stackImplementationOfQueue
        while (!auxiliaryStack.isEmpty()) {
            stackImplementationOfQueue.push(auxiliaryStack.pop());
        }
        //return the front element which is dequeued
        return dequeuedElement;
    }

    private void printQueue() {
        //printQueue is essentially printing the stackImplementationOfQueue
        System.out.println(stackImplementationOfQueue);
    }

    public static void main(String[] args) {

        ImplementEnqueueDequeueUsingStack implementEnqueueDequeueUsingStack = new ImplementEnqueueDequeueUsingStack();
        implementEnqueueDequeueUsingStack.enqueue(10);
        implementEnqueueDequeueUsingStack.enqueue(20);
        implementEnqueueDequeueUsingStack.enqueue(30);
        implementEnqueueDequeueUsingStack.enqueue(40);
        implementEnqueueDequeueUsingStack.enqueue(50);

        System.out.println("The current size of the queue is : " + stackImplementationOfQueue.size());

        //dequeue an element
        implementEnqueueDequeueUsingStack.dequeue();
        implementEnqueueDequeueUsingStack.dequeue();
        System.out.println("************************************************************************************");
        System.out.println("The current queue after dequeing an element is: ");
        implementEnqueueDequeueUsingStack.printQueue();
    }
}
