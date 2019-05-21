/**
 *
 */

package com.app.sa.joinThreads;


/**
 * @author iHSPA
 */
public class JoinThreadsB implements Runnable {

    @Override
    public void run ( ) {

        String name = Thread.currentThread ( ).getId ( ) + "===JoinThreadsB===" + Thread.currentThread ( ).getName ( );
        /*
         * Consider this as the second thread which is actually reading the data from the server. Imagine it will take 2
         * seconds and then it returns to the other threads to continue working.
         */
        System.out.println ( "Sending file/image from the Server..." );

        // Wait until the other thread has finished reading //
        for ( int i = 0; i < 4; i++ ) {
            System.out.println ( name + "===> Loading..." );
            try {
                Thread.sleep ( 250 );
            } catch ( InterruptedException e ) {
                e.printStackTrace ( );
            }
            System.out.println ( "Reading file/image from the Server completed..." );
        }
    }

}
