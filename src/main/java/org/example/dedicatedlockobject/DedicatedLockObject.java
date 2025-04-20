package org.example.dedicatedlockobject;

public class DedicatedLockObject {
    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Runnable task = () -> {
            for(int j = 0; j < 5; j++) {
                synchronized(lock) {
                    count++;
                    System.out.println(Thread.currentThread().getName() + " -> " + count);
                }
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        };

        new Thread(task, "Thread-1").start();
        new Thread(task, "Thread-2").start();
    }
}
