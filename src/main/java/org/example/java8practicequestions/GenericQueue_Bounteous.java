package org.example.java8practicequestions;

// Generic Queue Implementation in Java
public class GenericQueue_Bounteous<T> {
    private T[] queue; // Array to store queue elements
    private int front; // Index of the front element
    private int rear;  // Index of the rear element
    private int capacity; // Maximum capacity of the queue
    private int size;  // Current number of elements in the queue

    // Constructor to initialize the queue
    public GenericQueue_Bounteous(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity]; // Create a generic array
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Add an element to the queue
    public void enqueue(T element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full. Cannot add more elements.");
        }
        rear = (rear + 1) % capacity; // Move rear to the next position
        queue[rear] = element;
        size++;
    }

    // Remove and return the front element of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot remove elements.");
        }
        T element = queue[front];
        queue[front] = null; // Optional: Clear the position
        front = (front + 1) % capacity; // Move front to the next position
        size--;
        return element;
    }

    // Get the front element of the queue without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Nothing to peek.");
        }
        return queue[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Get the current size of the queue
    public int getSize() {
        return size;
    }

    // Display the queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Create a queue for integers with a capacity of 5
        GenericQueue_Bounteous<Integer> intQueue = new GenericQueue_Bounteous<>(5);

        // Enqueue elements
        intQueue.enqueue(10);
        intQueue.enqueue(20);
        intQueue.enqueue(30);

        // Display the queue
        intQueue.display();

        // Dequeue an element
        System.out.println("Dequeued: " + intQueue.dequeue());

        // Peek the front element
        System.out.println("Front element: " + intQueue.peek());

        // Display the queue
        intQueue.display();

        // Demonstrate with another type
        GenericQueue_Bounteous<String> stringQueue = new GenericQueue_Bounteous<>(3);
        stringQueue.enqueue("Alice");
        stringQueue.enqueue("Bob");

        stringQueue.display();
    }
}
