package org.example.Strings;

import java.util.*;

class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println("Working on task " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted, but continuing...");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Thread completed all tasks.");
    }
}

public class InterruptExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> la = List.of(1, 2, 3, 4, 5);
        System.out.println(la);
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "A");
        hm.put(2, "B");
        hm.put(3, "C");
        hm.put(4, "D");
        HashSet<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.forEach(System.out::println);
        Deque<Integer>D = new ArrayDeque<>();
        D.add(1);
        D.add(2);
        D.add(3);
        D.add(4);
        D.reversed();
        Queue<Integer>as= new LinkedList<>();
        Queue<Integer>ds=new ArrayDeque<>();
    }
}
