package com.rs.dsaPart1.linkedlist;

public class LinkedListAssignment {

    class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //two instance variables for the head and tail of a linked list
    private static Node head;
    private static Node tail;


    public void appendNodeAtTheEnd(int value) {

        //first create a Node
        Node newNode = new Node(value);
        //case when the node to be inserted happens to be the first node in the linked list
        if (head == null) {
            //point both head and tail to the newNode
            head = newNode;
            tail = newNode;
        } else {
            //case when there is a tail node and we want to append a node at the end
            tail.next = newNode;
            newNode.next = null;
            tail = newNode;
        }

    }

    //return true/false to check if there is a node existing with the given value
    //Lecture #17 Assignment : check if there is a node with value 6
    public boolean checkIfThereIsANodeWithAGivenValue(int value) {

        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }

        //if we end up reaching here , it means there is no node in the linked-list with the given value
        return false;

    }


    public void printLinkedList(Node headNode) {

        //start from the headNode
        Node current = headNode;

        while (current != null) {
            System.out.print(current.value + " ->");
            current = current.next;
        }
        System.out.print(current); // at this point current is null
    }

    //Lecture #21 Assignment: Java program to add node at the beginning with a given value
    public void addNodeAtTheBeginning(int value) {

        Node newNode = new Node(value);
        //case when theres no head
        if (head == null) {
            head = newNode;
            tail = newNode;
            //case when there happens to be a head already
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public int getLinkedListSize(Node headNode) {

        int count = 0;
        if (headNode == null) {
            return 0;
        } else {
            Node current = headNode;

            while (current != null) {
                current = current.next;
                count++;
            }
        }

        return count;
    }

    public void addNodeAtAGivenIndex(int value, int index) {

        if (index == 1)//case when we want to add/insert at the beginning
        {
            addNodeAtTheBeginning(value);
        } else if (index == getLinkedListSize(head) + 1)// case when we want to add at the end
        {
            appendNodeAtTheEnd(value);
        } else if (index > getLinkedListSize(head) + 1) {
            throw new RuntimeException("index mentioned where the new node is to be inserted is invalid ");
        } else {
            Node newNode = new Node(value);
            int count = 1;
            Node current = head;
            while (current != null && count != index - 1) {
                current = current.next;
                count++;
            }
            //at this point we are at the previous index of the index where we want to insert/add the newNode with given value

            //1. Store the reference of the next node in a temporary variable
            Node temp = current.next;
            //2. point the next of current to the new node
            current.next = newNode;
            //3. point the next of newNode to the tempNode that we smartly stored in step 1
            newNode.next = temp;
        }
    }

    public void removeNodeAtTheEnd() {

        //case when linkedlist itself is of size 1
        if (getLinkedListSize(head) == 1) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next.next != null) //logic to get to the penultimate node
            {
                current = current.next;
            }
            //we are at the penultimate node now
            current.next = null; // make the next node of penultimate node as null,destroy the connection to last node
            tail = current; // make the penultimate node as the tail
        }

    }

    public void removeNodeAtTheBeginning() {

        //case when linkedlist itself is of size 1, we have to remove the head
        if (getLinkedListSize(head) == 1) {
            head = null;
            tail = null;
        } else {
            //make the next node of current head as the head
            head = head.next;
        }

    }

    //Lecture #26 Assignment: delete node at a given index
    public void removeNodeAtAGivenIndex(int index) {

        //case when we need to remove the head node
        if (index == 1) {
            removeNodeAtTheBeginning();
        } else if (index == getLinkedListSize(head)) {
            //case when we need to remove the tail node
            removeNodeAtTheEnd();
        } else {
            int count = 1;
            Node current = head;
            while (current != null && count != index - 1) {
                current = current.next;
                count++;
            }
            //at this point we are at the previous index of the index where we want to delete node
            // point the next of current to the next of next to remove the connection with the next node
            current.next = current.next.next;
        }
    }

    //Lecture #27 Assignment Part 1 : Implementing a function to delete a node with a given value
    public void deleteNodeWithAGivenValue(int value) {

        //case when we need to remove the head node
        if (head.value == value) {
            removeNodeAtTheBeginning();
        } else if (tail.value == value) {
            //case when we need to remove the tail node
            removeNodeAtTheEnd();
        } else {
            Node current = head;
            Node previous = null;
            while (current != null && current.value != value) {
                //store the value of current in previous
                previous = current;
                current = current.next;
            }

            //case when the given value node  is not found
            if (current == null) {
                throw new RuntimeException("the node with the given value is not found!!");
            }
            //at this point we have the information of the previous node to the node with given value which we want to delete
            //and current node is the node that we want to delete
            previous.next = current.next;
        }
    }

    //Lecture #27 Assignment Part 2(using the deleteNodeWithAGivenValue() function here): remove all nodes with even values
    public void deleteAllNodesWithEvenValues() {

        Node current = head;
        while (current != null) {

            if (current.value % 2 == 0) {
                deleteNodeWithAGivenValue(current.value);
            }
            current = current.next;
        }

    }

    public void reverseLinkedList() {

        //we will take 3 pointer approach to solve this problem

        Node current = head;
        Node next = null;
        Node previous = null;

        while (current != null) {
            //1. Store the next reference of current node in next variable
            next = current.next;
            //2. Point the next of current node to previous node
            current.next = previous;
            //3. current becomes previous
            previous = current;
            //4. next becomes current
            current = next;
        }
        //when we reach here current is null , we have reversed the linked list , we make the head as previous
        head = previous;
    }


    public static void main(String[] args) {

        LinkedListAssignment linkedListAssignment = new LinkedListAssignment();
        linkedListAssignment.appendNodeAtTheEnd(10);
        linkedListAssignment.appendNodeAtTheEnd(20);
        linkedListAssignment.appendNodeAtTheEnd(30);
        linkedListAssignment.appendNodeAtTheEnd(40);
        linkedListAssignment.appendNodeAtTheEnd(50);
        linkedListAssignment.addNodeAtTheBeginning(5);
        linkedListAssignment.addNodeAtTheBeginning(1);
        linkedListAssignment.addNodeAtAGivenIndex(0, 1);

        linkedListAssignment.printLinkedList(LinkedListAssignment.head);
        System.out.println();
        System.out.println("The current size of the linked list is : " + linkedListAssignment.getLinkedListSize(LinkedListAssignment.head));

/*        linkedListAssignment.removeNodeAtTheEnd();
        System.out.println();
        System.out.println("The current size of the linked list after deleting the last node is : " + linkedListAssignment.getLinkedListSize(LinkedListAssignment.head));
        System.out.println();
        linkedListAssignment.printLinkedList(LinkedListAssignment.head);*/
/*
        linkedListAssignment.removeNodeAtTheBeginning();
        System.out.println();
        System.out.println("The current size of the linked list after deleting the first node is : " + linkedListAssignment.getLinkedListSize(LinkedListAssignment.head));
        System.out.println();
        linkedListAssignment.printLinkedList(LinkedListAssignment.head);*/

        /*linkedListAssignment.removeNodeAtAGivenIndex(8);
        System.out.println();
        System.out.println("The current size of the linked list after deleting the  node at given index is : " + linkedListAssignment.getLinkedListSize(LinkedListAssignment.head));
        System.out.println();
        linkedListAssignment.printLinkedList(LinkedListAssignment.head);*/

        /*linkedListAssignment.deleteNodeWithAGivenValue(80);
        System.out.println();
        System.out.println("The current size of the linked list after deleting the  node with given value is : " + linkedListAssignment.getLinkedListSize(LinkedListAssignment.head));
        System.out.println();
        linkedListAssignment.printLinkedList(LinkedListAssignment.head);*/

        /*linkedListAssignment.deleteAllNodesWithEvenValues();
        System.out.println();
        System.out.println("The current size of the linked list after deleting all nodes with even values is : " + linkedListAssignment.getLinkedListSize(LinkedListAssignment.head));
        System.out.println();
        linkedListAssignment.printLinkedList(LinkedListAssignment.head);*/

        /*linkedListAssignment.reverseLinkedList();
        System.out.println();
        System.out.println("The current size of the linked list after reversing the linked list is : " + linkedListAssignment.getLinkedListSize(LinkedListAssignment.head));
        System.out.println();
        linkedListAssignment.printLinkedList(LinkedListAssignment.head);*/

        System.out.println(linkedListAssignment.checkIfThereIsANodeWithAGivenValue(7));

    }


}
