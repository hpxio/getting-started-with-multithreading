/**
 *
 */

package com.app.sa.basics;


import static com.app.sa.conso.consoleIO.ANSI_GREEN;
import static com.app.sa.conso.consoleIO.ANSI_PURPLE;


/**
 * @author iHSPA
 */
public class UsingThreadClass extends Thread {


    @Override
    public void run ( ) {
        // super.run();
        String name = Thread.currentThread ( ).getId ( ) + "--Thread--" + Thread.currentThread ( ).getName ( );

        for ( int i = 0; i < 10; i++ ) {
            // Do some random operations in thread //
            System.out.println ( ANSI_PURPLE + "Printing from... " + name + "::" + i );

            // Sleep for 0.5 Sec //
            try {
                sleep ( 500 );
            } catch ( InterruptedException e ) {
                e.printStackTrace ( );
            }

        }
        System.out.println ( ANSI_GREEN + "Thread " + name + "  activity completed..." );
    }

}
