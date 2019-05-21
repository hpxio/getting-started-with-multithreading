/**
 *
 */

package com.app.sa.interruptThreads;


/**
 * @author ucom
 */
public class InterruptedClass implements Runnable {

    @Override
    public void run ( ) {
        String name = Thread.currentThread ( ).getId ( ) + "===Interrupted-Class==="
                + Thread.currentThread ( ).getName ( );

        // Do some random operation //
        for ( int i = 0; i < 10; i++ ) {
            System.out.println ( name + "..." + i );

            try {
                Thread.sleep ( 1000 );
            } catch ( InterruptedException e ) {
                // e.printStackTrace ( );
                System.out.println ( name + "...got Interrupted..." );
                return;
                // System.exit ( 0 );
            }
        }

    }


}
