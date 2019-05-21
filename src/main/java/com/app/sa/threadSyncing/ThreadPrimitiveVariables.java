
package com.app.sa.threadSyncing;

public class ThreadPrimitiveVariables {

    public static execForPrimitiveLocalVar localPrimitive = new execForPrimitiveLocalVar();

    public static execForPrimitiveClassVar classPrimitive = new execForPrimitiveClassVar();

    public static void main(String[] args) {

        boolean flag = true;

        if (flag) {
            System.out.println("Local Primitive Value...");
            localPrimitive.startExecution();
        } else {
            System.out.println("Class Primitive Value...");
            classPrimitive.startExecution();
        }
    }
}

class execForPrimitiveClassVar {

    // Both threads using common object

    UsingPrimitveClassVar f = new UsingPrimitveClassVar();

    Thread t1 = new Thread(f);

    Thread t2 = new Thread(f);

    public void startExecution() {
        t1.start();
        t2.start();
    }
}

class execForPrimitiveLocalVar {

    // Both threads using common object
    UsingPrimitiveLocalVar d = new UsingPrimitiveLocalVar();

    Thread t1 = new Thread(d);

    Thread t2 = new Thread(d);

    public void startExecution() {
        t1.start();
        t2.start();
    }
}

/**
 * Demo using class variable.
 */
class UsingPrimitiveLocalVar implements Runnable {

    // Change local variable in
    // different threads //
    public void increment() {

        // Local Variable - Primitive
        // Type //
        // int ctr = 0;
        // while ( ctr <= 5 )
        // System.out.println ( ctr++ +
        // "::" + Thread.currentThread (
        // ).getName ( ) );
    }

    @Override
    public void run() {
        // increment ( );
        int ctr = 0;
        while (ctr <= 5)
            System.out.println(ctr++ + "::"
                    + Thread.currentThread().getName());
    }
}

/**
 * Demo using class variable.
 */
class UsingPrimitveClassVar implements Runnable {

    // Class Variable - Primitive Type
    // //
    private int ctr = 0;

    // Change class variable in
    // different thread //
    public void increment() {
        // while ( ctr <= 5 )
        // System.out.println ( ctr++ +
        // "::" + Thread.currentThread (
        // ).getName ( ) );
    }

    @Override
    public void run() {
        // increment ( );
        while (ctr <= 5)
            System.out.println(ctr++ + "::"
                    + Thread.currentThread().getName());
    }
}