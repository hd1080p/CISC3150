/* Harris Dizdarevic
 * CISC. 3150
 * Homework 10
 * Create a program where 4 Threads synchronously print
 * A B C D ... Z
 */

import java.util.concurrent.locks.*;

public class HomeworkTen {
    public static void main(String[] args) throws Throwable{
        PrintAlphabet p = new PrintAlphabet();
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        Thread t3 = new Thread(p);
        Thread t4 = new Thread(p);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

class PrintAlphabet implements Runnable {
    Lock L = new ReentrantLock();
    char alpha = 'A';

    Condition next = L.newCondition();
    Condition curr = L.newCondition();

    public void alphabet() {
        L.lock();
        try {
            while(this.alpha <= 'Z') {
                this.printCharacter();
                this.alpha += 1;
                curr.await();
                Thread.sleep(50);
                curr.signal();
            }
        } catch(Throwable T) {
            //Do Nothing
        } finally {
            L.unlock();
        }
    }

    public void printCharacter() throws Throwable{
        curr.signal();
        System.out.printf(alpha + " ");
        System.out.println(Thread.currentThread().getName());
        next.signal();
    }

    public void run() {
            this.alphabet();
    }

}
