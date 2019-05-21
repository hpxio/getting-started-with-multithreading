
package com.app.sa.threadSyncing;


import java.util.ArrayList;
import java.util.List;


public class WaitAndNotify {


    private static PC pcInstance = new PC ( );

    private static Thread t1 = new Thread ( new Runnable ( ) {

        @Override
        public void run ( ) {
            try {
                pcInstance.producer ( );
            } catch ( InterruptedException e ) {
                e.printStackTrace ( );
            }
        }
    } );

    private static Thread t2 = new Thread ( new Runnable ( ) {

        @Override
        public void run ( ) {
            pcInstance.consumer ( );
        }
    } );

    public static void main ( String[] args ) {
        t1.start ( );

        try {
            Thread.sleep ( 250 );
        } catch ( InterruptedException e ) {
            e.printStackTrace ( );
        }

        t2.start ( );
    }

}


class PC {

    int max = 4;

    int val = 457;

    boolean isReady = false;

    List< Integer > data = new ArrayList<> ( );

    public synchronized void producer ( ) throws InterruptedException {

        while ( !isReady ) {
            if ( data.size ( ) <= max ) {
                data.add ( val++ );
            } else {
                System.out.println ( "Producer has finished generation..." );
                break;
            }
        }

        isReady = true;
        wait ( );


        System.out.println ( "Producer is resuming generation..." );
    }

    public synchronized void consumer ( ) {

        while ( isReady ) {
            for ( Integer i : data ) {
                System.out.println ( "Data::" + i + "::" + Thread.currentThread ( ).getName ( ) );
                // data.remove ( i );
            }
            break;
        }
        System.out.println ( "Consumer has consumed production..." );
        isReady = false;
        notify ( );
    }

}
