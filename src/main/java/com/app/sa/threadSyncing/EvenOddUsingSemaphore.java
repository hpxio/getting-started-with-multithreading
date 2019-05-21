
package com.app.sa.threadSyncing;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


public class EvenOddUsingSemaphore {

    public static void main ( String[] args ) {
        SharedPrinterSemaphore sp = new SharedPrinterSemaphore ( );
        // Starting two threads
        ExecutorService executor = Executors
                .newFixedThreadPool ( 2 );
        executor.execute ( new EvenNumProducer ( sp, 10 ) );
        executor.execute ( new OddNumProducer ( sp, 10 ) );
        executor.shutdown ( );
    }
}


// Shared class used by both threads
class SharedPrinterSemaphore {

    boolean evenFlag = false;

    // 2 semaphores
    Semaphore semEven = new Semaphore ( 0 );

    Semaphore semOdd = new Semaphore ( 1 );

    // Method for printing even numbers
    public void printEvenNum ( int num ) {
        try {
            semEven.acquire ( );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace ( );
        }
        System.out.println ( num + "::EVEN" );
        semOdd.release ( );
    }

    // Method for printing odd numbers
    public void printOddNum ( int num ) {
        try {
            semOdd.acquire ( );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace ( );
        }
        System.out.println ( num + "::ODD" );
        semEven.release ( );

    }
}


// Thread Class generating Even numbers
class EvenNumProducer implements Runnable {

    SharedPrinterSemaphore sp;

    int index;

    EvenNumProducer ( SharedPrinterSemaphore sp,
            int index ) {
        this.sp = sp;
        this.index = index;
    }

    @Override
    public void run ( ) {
        for ( int i = 2; i <= index; i = i + 2 ) {
            sp.printEvenNum ( i );
        }
    }
}


// Thread Class generating Odd numbers
class OddNumProducer implements Runnable {

    SharedPrinterSemaphore sp;

    int index;

    OddNumProducer ( SharedPrinterSemaphore sp,
            int index ) {
        this.sp = sp;
        this.index = index;
    }

    @Override
    public void run ( ) {
        for ( int i = 1; i <= index; i = i + 2 ) {
            sp.printOddNum ( i );
        }
    }
}