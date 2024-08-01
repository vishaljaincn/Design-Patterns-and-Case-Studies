package org.example.Print123with3diffThreadsandsoontill10;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);
        Count count = new Count();

        Num1 num1 = new Num1(s1, s2, s3, count);
        Thread t1 = new Thread(num1);
        t1.start();
        Num2 num2 = new Num2(s1, s2, s3, count);
        Thread t2 = new Thread(num2);
        t2.start();
        Num3 num3 = new Num3(s1, s2, s3, count);
        Thread t3 = new Thread(num3);
        t3.start();

    }
}