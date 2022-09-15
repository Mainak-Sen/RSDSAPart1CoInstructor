package com.rs.dsaPart1.queue;

public class ImplementPriorityQueueUsingArray {

    private int front;
    private int rear;
    private int[] arrayImpl;
    private int size;

    ImplementPriorityQueueUsingArray(int size) {

        //initially there is no one in the queue so setting rear as -1
        this.rear = -1;
        this.size = size;
        this.arrayImpl = new int[size]; //instantiating the array with size equal to size of the queue

    }

    //implement enqueue ,enqueue new element at the rear, but with the logic that only the elements with higher priority
    //should be at the first
    private void enqueue(int x) {
        if (rear == -1) {
            rear++;
            arrayImpl[rear] = x;
        } else {
            for (int i = rear; i >= 0; i--) {
                if (arrayImpl[i] > x) {
                    arrayImpl[i + 1] = arrayImpl[i];
                    if (i == 0) {
                        arrayImpl[i] = x;
                    }
                } else {
                    arrayImpl[i + 1] = x;
                    break;
                }
            }
            rear++;
        }
    }

    //implement dequeue, dequeue an element from the front (FIFO mechanism)
    private int dequeue() {

        //smartly store the front element to be dequeued
        int element = arrayImpl[0];
        for (int i = 0; i < rear; i++) {
            arrayImpl[i] = arrayImpl[i + 1]; //this shifts the elements one place towards left ,making the front element gone
        }
        //remove the extraneous rear element left after shifting the places of elements  leftwards
        rear--;
        //return the front element
        return element;
    }

    private void printQueue() {

        for (int i = 0; i <= rear; i++) {
            System.out.print(arrayImpl[i] + " ");
        }

    }

    public static void main(String[] args) {

        ImplementPriorityQueueUsingArray implementPriorityQueueUsingArray = new ImplementPriorityQueueUsingArray(6);
//        implementPriorityQueueUsingArray.enqueue(10);
//        implementPriorityQueueUsingArray.enqueue(5);
//        implementPriorityQueueUsingArray.enqueue(3);
        //implementPriorityQueueUsingArray.enqueue(40);
        implementPriorityQueueUsingArray.enqueue(58);
//        implementPriorityQueueUsingArray.enqueue(9);

        System.out.println("The current size of the queue is : " + implementPriorityQueueUsingArray.size);

        //dequeue an element
        implementPriorityQueueUsingArray.dequeue();
        System.out.println("************************************************************************************");
        System.out.println("The current queue is: ");
        implementPriorityQueueUsingArray.printQueue();


    }
}
