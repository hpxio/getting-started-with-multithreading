/**
 *
 */

package com.app.sa.basics;


/**
 * @author iHSPA
 */
public class UsingRunnableInterface implements Runnable {

    @Override
    public void run ( ) {
        // super.run();
        String name = Thread.currentThread ( ).getId ( ) + "--Thread--" + Thread.currentThread ( ).getName ( );

        for ( int i = 0; i < 10; i++ ) {
            // Do some random operations in thread //
            System.out.println ( "Printing from... " + name + i );

            // Sleep for 0.5 Sec //
            try {
                Thread.sleep ( 500 );
            } catch ( InterruptedException e ) {
                e.printStackTrace ( );
            }

        }
        System.out.println ( "Thread " + name + "  activity completed..." );

    }

}
