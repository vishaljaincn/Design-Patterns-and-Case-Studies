package org.example.java8practicequestions;

class ListNode {
    int value;  // Value of the node
    ListNode next;  // Reference to the next node

    // Constructor for a node with just a value
    ListNode(int value) {
        this.value = value;
    }

    // Constructor for a node with both value and next node reference
    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

public class PWC_ListImpl {

    public static void main(String[] args) {
        // Question: Create a singly linked list with 10 nodes and print each node's value.

        // Initialize the head node with value 0
        ListNode head = new ListNode(0);

        // Pointer to the current node, starting with the head
        ListNode currentNode = head;

        // Create nodes with values 1 through 9 and link them together
        for (int i = 1; i < 10; i++) {
            ListNode newNode = new ListNode(i);  // Create a new node with value i
            currentNode.next = newNode;  // Link the current node to the new node
            currentNode = newNode;  // Move to the new node
        }

        // Iterate through the list and print the values of each node
        ListNode iterator = head;  // Start from the head of the list
        while (iterator != null) {
            System.out.println(iterator.value);  // Print the value of the current node
            iterator = iterator.next;  // Move to the next node
        }
    }

}
