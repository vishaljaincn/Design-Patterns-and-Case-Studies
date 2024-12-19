package org.example;

public class Main {
    public static void main(String args[]) {

        ThreadLocal<String> threadLocalObj = new ThreadLocal<>();

        //main thread
        threadLocalObj.set(Thread.currentThread().getName());

        Thread thread1 = new Thread(() -> {
            threadLocalObj.set("nigga");
            System.out.println(threadLocalObj.get());
        });

        thread1.start();

        try {
            Thread.sleep(110);
        } catch (Exception e) {
        }
       // threadLocalObj.set("bastardkkkk");
        //here we have main thread
        System.out.println(threadLocalObj.get());
    }

}