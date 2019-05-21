
package com.app.sa.threadSyncing;

public class EvenOdd {

    public static void main ( String[] args ) {
        Thread T1 = new Thread ( new EO ( 1 ), "T1" );
        Thread T2 = new Thread ( new EO ( 0 ), "T2" );

        T1.start ( );
        T2.start ( );
    }

}


class EO implements Runnable {

    int MAX = 20;

    static int NUM = 1;

    int REM;

    static Object lock = new Object ( );

    public EO ( ) {
    }

    public EO ( int remainder ) {
        REM = remainder;
    }

    @Override
    public void run ( ) {

        while ( NUM < MAX ) {
            synchronized ( lock ) {
                while ( NUM % 2 != REM ) {
                    try {
                        lock.wait ( );
                    } catch ( InterruptedException e ) {
                        e.printStackTrace ( );
                    }
                }
                System.out.println ( NUM + "::" + Thread
                        .currentThread ( ).getName ( ) );
                NUM++;
                lock.notifyAll ( );
            }
        }
    }
}