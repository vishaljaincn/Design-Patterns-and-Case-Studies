package org.example.java8practicequestions;

/*
The use of %capacity throughout your code implements a circular queue (ring buffer) pattern. This is an efficient design that allows you to:


Reuse array space after dequeues
Avoid shifting elements when adding/removing (which would be O(n))
Maintain constant time O(1) operations for enqueue and dequeue
Let me explain where and why it's used:

explain it with a dry run what r u trying to say here?

I'll explain the circular queue concept with a step-by-step dry run of how your implementation works using the modulo (`% capacity`) operation.

Let's use a queue with capacity 5:

### Initial State
```
Array: [null, null, null, null, null]
front: 0
rear: -1
size: 0
```

### After enqueuing three values
```
enqueue(10) → rear becomes 0, array: [10, null, null, null, null]
enqueue(20) → rear becomes 1, array: [10, 20, null, null, null]
enqueue(30) → rear becomes 2, array: [10, 20, 30, null, null]
front: 0, rear: 2, size: 3
```

### After dequeue()
```
dequeue() returns 10
front becomes 1
array: [null, 20, 30, null, null]
front: 1, rear: 2, size: 2
```

### Now let's fill the queue
```
enqueue(40) → rear becomes 3, array: [null, 20, 30, 40, null]
enqueue(50) → rear becomes 4, array: [null, 20, 30, 40, 50]
front: 1, rear: 4, size: 4
```

### The circular behavior becomes visible
```
enqueue(60):
  rear = (4 + 1) % 5 = 0
  array: [60, 20, 30, 40, 50]
front: 1, rear: 0, size: 5
```

The queue has "wrapped around" - the newest element (60) is now at index 0, while the oldest element (20) is at index 1.

This circular design:
- Avoids shifting elements (which would be O(n))
- Allows reusing freed space at the beginning
- Maintains O(1) time complexity for enqueue/dequeue operations
- Efficiently uses the fixed-size array

The modulo operations ensure the indices always stay within the array bounds while creating this circular structure.
 */
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
        rear = (rear + 1) % capacity; // Using modulo to wrap around to beginning of array when reaching the end
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
        front = (front + 1) % capacity; // Using modulo to wrap around to beginning of array when reaching the end
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
            System.out.print(queue[(front + i) % capacity] + " "); // Using modulo to handle circular indexing
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
