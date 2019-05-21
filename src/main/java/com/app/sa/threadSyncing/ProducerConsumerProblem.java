
package com.app.sa.threadSyncing;


import java.util.ArrayList;
import java.util.List;


public class ProducerConsumerProblem {

    private static MyPC pc = new MyPC ( );

    private static Thread t1 = new Thread ( new Runnable ( ) {

        @Override
        public void run ( ) {
            try {
                pc.producer ( );
            } catch ( InterruptedException e ) {
                e.printStackTrace ( );
            }
        }
    } );

    private static Thread t2 = new Thread ( new Runnable ( ) {

        @Override
        public void run ( ) {
            try {
                pc.consumer ( );
            } catch ( InterruptedException e ) {
                e.printStackTrace ( );
            }
        }
    } );

    public static void main ( String[] args ) {
        t1.start ( );
        t2.start ( );

        try {
            t1.join ( );
        } catch ( InterruptedException e ) {
            e.printStackTrace ( );
        }
        try {
            t2.join ( );
        } catch ( InterruptedException e ) {
            e.printStackTrace ( );
        }
    }

}


class MyPC {

    int max = 12;

    int val = 39;

    List< Integer > data = new ArrayList<> ( );


    public synchronized void producer ( ) throws InterruptedException {

        while ( true ) {
            if ( data.size ( ) == max ) {
                wait ( );
            }

            System.out.println ( "Start Production..." );
            while ( data.size ( ) <= max ) {
                data.add ( val++ );
            }
            System.out.println ( "Production Completed..." );
            notify ( );

            Thread.sleep ( 1000 );
        }
    }


    public synchronized void consumer ( ) throws InterruptedException {

        while ( true ) {
            if ( data.size ( ) == 0 ) {
                wait ( );
            }

            System.out.println ( "Consuming Production..." );
            int sz = data.size ( );
            while ( data.size ( ) > 0 ) {
                int iv = data.remove ( --sz );
                System.out.println ( "Consumed..." + iv );
            }
            System.out.println ( "Consumption Completed..." );
            notify ( );
            Thread.sleep ( 1000 );
        }
    }

}
