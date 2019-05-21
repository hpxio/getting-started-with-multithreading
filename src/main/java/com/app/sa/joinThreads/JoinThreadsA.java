/**
 *
 */

package com.app.sa.joinThreads;


/**
 * @author iHSPA
 */
public class JoinThreadsA implements Runnable {

    @SuppressWarnings ( "unused" )
    final private Thread threadB = new Thread ( new JoinThreadsB ( ) );

    @Override
    public void run ( ) {

        String name = Thread.currentThread ( ).getId ( ) + "===JoinThreadsA===" + Thread.currentThread ( ).getName ( );
        /*
         * Consider this as the first thread which invokes another thread to read data from file or download an image
         * from server. Meanwhile it cannot hang on the UI so it shows a progress dialog box with percentage of
         * file/image loaded.
         */
        System.out.println ( "Reading file/image from the Server..." );

        // Wait until the other thread has finished reading //
        for ( int i = 0; i < 4; i++ ) {
            System.out.println ( name + "===> Waiting..." );
            try {
                Thread.sleep ( 1000 );
            } catch ( InterruptedException e ) {
                e.printStackTrace ( );
            }
        }
        System.out.println ( "Reading file/image from the Server completed..." );
    }
}
