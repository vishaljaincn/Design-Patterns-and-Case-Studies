package org.example.IterableVsIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Node implements Iterable<Node> {
    // Private member variable to store the data of the node
    private int data;
    // Private member variable to store the reference to the next node
    private Node next;

    // Constructor to initialize the node with data and reference to the next node
    public Node(int data, Node next) {
        this.data = data; // Set the data
        this.next = next; // Set the reference to the next node
    }

    // Getter method for the data field
    public int getData() {
        return this.data; // Return the data of the current node
    }


    // Override the iterator method to return an instance of NodeIterator
    @Override
    public Iterator<Node> iterator() {
        return new NodeIterator(this); // Create and return a new NodeIterator starting at this node
    }

    // Nested static class that implements the Iterator interface for Node
    private static class NodeIterator implements Iterator<Node> {
        // Private member variable to keep track of the current node in the iteration
        private Node current;

        // Constructor to initialize the iterator with the start node
        public NodeIterator(Node start) {
            this.current = start; // Set the current node to the start node
        }

        // Override the hasNext method to check if there is a next node in the iteration
        @Override
        public boolean hasNext() {
            return current != null; // Return true if the current node is not null, otherwise false
        }

        // Override the next method to return the current node and move to the next node
        @Override
        public Node next() {
            // If there is no next node, throw a NoSuchElementException
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            // Store the current node in a temporary variable
            Node temp = current;
            // Move to the next node
            current = current.next;
            // Return the current node
            return temp;
        }
    }

    // Main method to test the Node and NodeIterator classes
    public static void main(String[] args) {
        // Create the third node with data 3 and no next node (end of the list)
        Node node3 = new Node(3, null);
        // Create the second node with data 2 and the third node as the next node
        Node node2 = new Node(2, node3);
        // Create the first node with data 1 and the second node as the next node
        Node node1 = new Node(1, node2);

        // Use an enhanced for-loop to iterate over the nodes starting from node1
        for (Node node : node1) {
            // Print the data of each node
            System.out.println(node.getData());
        }
    }
}
