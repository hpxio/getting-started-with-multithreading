
package com.app.sa.threadSyncing;

/**
 * <p>
 * <b>When to Use ThreadLocal</b><br/>
 * When you want to use a shared variable in threads but you
 * want to have a separate copy for all of your threads then
 * ThreadLocal is better choice. If you use Synchronization
 * in such scenarios then the values will be overwritten by
 * different threads depending on the sequence of calling.
 * </p>
 * 
 * @author gur40401
 */
public class ThreadLocalClass {

    private static ThreadLocal<String> TLocalString = new ThreadLocal<String>();

    public static void exec() {

        new Thread(new Runnable() {

            @Override
            public void run() {
                TLocalString.set("Init...");
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(TLocalString.get());
            }

        }).start();

    }

    public static void main(String[] args) {
    }

}
