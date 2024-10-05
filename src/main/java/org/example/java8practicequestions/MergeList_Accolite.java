package org.example.java8practicequestions;

class ListNodes {
    int value;
    ListNodes next;

    ListNodes(int value) {
        this.value = value;
    }

    ListNodes(int value, ListNodes next) {
        this.value = value;
        this.next = next;
    }
}

public class MergeList_Accolite {
    public static ListNodes mergeList(ListNodes a, ListNodes b) {
        ListNodes dummy = new ListNodes(-1);
        ListNodes current = dummy;

        while (a != null && b != null) {
            if (a.value <= b.value) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }

        // Attach remaining nodes
        current.next = (a != null) ? a : b;

        return dummy.next;
    }

    // Utility method to print a linked list
    public static void printList(ListNodes head) {
        ListNodes current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    // 2 7 4 3
    public static void main(String[] args) {
        // Creating two sorted linked lists
        ListNodes l1 = new ListNodes(2, new ListNodes(3, new ListNodes(5, new ListNodes(7))));
        ListNodes l2 = new ListNodes(1, new ListNodes(3, new ListNodes(5, new ListNodes(7))));
        ListNodes l3 = new ListNodes(2, new ListNodes(7, new ListNodes(4, new ListNodes(3))));
        // Merging the lists
        ListNodes mergedList = mergeList(l1, l2);

        // Printing the merged list
        System.out.print("Merged List: ");
        printList(mergedList);
        printList(l3);
    }
}

