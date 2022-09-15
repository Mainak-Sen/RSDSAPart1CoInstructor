package com.rs.dsaPart1.queue;

public class ImplementEnqueueDequeueUsingArray {

    private int front;
    private int rear;
    private int[] arrayImpl;
    private int size;

    ImplementEnqueueDequeueUsingArray(int size) {

        //initially there is no one in the queue so setting rear as -1
        this.rear = -1;
        this.size = size;
        this.arrayImpl = new int[size]; //instantiating the array with size equal to size of the queue

    }

    //implement enqueue ,enqueue new element at the rear
    private void enqueue(int x) {
        rear++;
        arrayImpl[rear] = x;
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

        ImplementEnqueueDequeueUsingArray implementEnqueueDequeueUsingArray = new ImplementEnqueueDequeueUsingArray(5);
        implementEnqueueDequeueUsingArray.enqueue(10);
        implementEnqueueDequeueUsingArray.enqueue(20);
        implementEnqueueDequeueUsingArray.enqueue(30);
        implementEnqueueDequeueUsingArray.enqueue(40);
        implementEnqueueDequeueUsingArray.enqueue(50);

        System.out.println("The current size of the queue is : " + implementEnqueueDequeueUsingArray.size);

        //dequeue an element
        implementEnqueueDequeueUsingArray.dequeue();
        System.out.println("************************************************************************************");
        System.out.println("The current queue is: ");
        implementEnqueueDequeueUsingArray.printQueue();


    }
}
