package org.example.Print123with3diffThreadsandsoontill10;

import java.util.concurrent.Semaphore;

public class Num1 implements Runnable {
    Semaphore s1;
    Semaphore s2;
    Semaphore s3;
    Count value;

    Num1(Semaphore s1, Semaphore s2, Semaphore s3, Count value) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.value = value;
    }

    public void run() {
        try {

            while (value.value <= 10) {
                s1.acquire();
                if (value.value <= 10) {
                    System.out.println(Thread.currentThread().getName() + " : " + value.value);
                    value.value += 1;
                }
                s2.release();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
