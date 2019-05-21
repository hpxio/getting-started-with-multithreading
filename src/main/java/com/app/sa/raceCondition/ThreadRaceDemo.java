
package com.app.sa.raceCondition;

/**
 * Demo for the race condition.
 */

class ThreadRace implements Runnable {

    int tickets = 1;

    public void bookTickets ( ) {
        System.out.println ( "Tickets Available::" + tickets
                + "::"
                + Thread.currentThread ( ).getName ( ) );
        if ( tickets >= 1 ) {
            System.out.println ( "Tickets booked..."
                    + Thread.currentThread ( )
                            .getName ( ) );
            tickets--;
        } else {
            System.err.println ( "Tickets not booked..."
                    + Thread.currentThread ( )
                            .getName ( ) );
        }
        System.out.println ( "Tickets Available::" + tickets
                + "::"
                + Thread.currentThread ( ).getName ( ) );
    }

    /**
     * When an object implementing interface
     * <code>Runnable</code> is used to create a thread,
     * starting the thread causes the object's
     * <code>run</code> method to be called in that
     * separately executing thread.
     * <p>
     * The general contract of the method <code>run</code>
     * is that it may take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run ( ) {
        bookTickets ( );

    }
}


class ResolveThreadRace implements Runnable {

    // private int tickets = 1;
    // <== OR ==> //
    private volatile int tickets = 1;

    synchronized public void bookTickets ( ) {
        System.out.println (
                "Tickets Available Before Booking::"
                        + tickets + "::"
                        + Thread.currentThread ( )
                                .getName ( ) );
        if ( tickets >= 1 ) {
            System.out.println ( "Tickets booked..."
                    + Thread.currentThread ( )
                            .getName ( ) );
            tickets--;
        } else {
            System.err.println ( "\nTickets not booked..."
                    + Thread.currentThread ( )
                            .getName ( ) );
        }
        System.out.println (
                "Tickets Available After Booking::"
                        + tickets + "::"
                        + Thread.currentThread ( )
                                .getName ( ) );
    }

    /**
     * When an object implementing interface
     * <code>Runnable</code> is used to create a thread,
     * starting the thread causes the object's
     * <code>run</code> method to be called in that
     * separately executing thread.
     * <p>
     * The general contract of the method <code>run</code>
     * is that it may take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run ( ) {
        bookTickets ( );
    }
}


@SuppressWarnings ( "unused" )
public class ThreadRaceDemo {

    private static Runnable r = new ThreadRace ( );

    private static Thread t1 = new Thread ( r, "T1" );

    private static Thread t2 = new Thread ( r, "T2" );

    private static Runnable rr = new ResolveThreadRace ( );

    private static Thread t3 = new Thread ( rr, "T3" );

    private static Thread t4 = new Thread ( rr, "T4" );

    public static void main ( String[] args ) {
        // t1.start ( );
        // t2.start ( );

        t4.start ( );
        t3.start ( );

    }

}
