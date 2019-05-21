
package com.app.sa.threadSyncing;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerMySolution {

    public static void main(String[] args) {
        AFWQEDSDGSD pc = new AFWQEDSDGSD();

        Thread T1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread T2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        T2.start();
        T1.start();
        try {
            T1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            T2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class AFWQEDSDGSD {
    Queue<Integer> L = new LinkedList<>();
    int MAX = 2;
    int REP = 10;
    int VAL = 0;

    public void producer() throws InterruptedException {

        // Produce for REP cycles //
        for (int i = 0; i < REP; i++) {
            synchronized (this) {

                // first check if list is ready to consume
                while (L.size() >= MAX) {
                    wait();
                }

                // add new data if list empty
                VAL++;
                L.add(VAL);
                System.out.println("PRODUCER::"
                        + Thread.currentThread().getName()
                        + "::" + VAL);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consumer() throws InterruptedException {
        for (int i = 0; i < REP; i++) {
            synchronized (this) {

                while (L.size() == 0) {
                    wait();
                }

                int some = L.poll();
                System.out.println("CONSUMER::"
                        + Thread.currentThread().getName()
                        + "::" + some);

                notify();
                Thread.sleep(1000);
            }
        }
    }
}