package edu.nyu.cs9053.homework9;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: blangel
 * Date: 11/11/14
 * Time: 8:25 AM
 */
public class PhilosopherRunner implements Runnable {

    private final DiningTable diningTable;

    private final Philosopher philosopher;

    private final Chopstick rightChopstick;

    private final Chopstick leftChopstick;

    private final Random random;

    private final AtomicInteger attemptsWithoutEating;

    public PhilosopherRunner(DiningTable diningTable, Philosopher philosopher,
                             Chopstick rightChopstick, Chopstick leftChopstick, Random random) {
        this.diningTable = diningTable;
        this.philosopher = philosopher;
        this.rightChopstick = rightChopstick;
        this.leftChopstick = leftChopstick;
        this.random = random;
        this.attemptsWithoutEating = new AtomicInteger(0);
    }

    @Override public void run() {
        Callback callback = new Callback() {
            @Override public void pickedUpChopstick(Chopstick chopstick) {
                System.out.printf("%s picked up his %s Chopstick%n", philosopher.getName(), (chopstick == leftChopstick ? "left" : "right"));
                diningTable.pickup(philosopher, chopstick);
            }
            @Override public void putDownChopstick(Chopstick chopstick) {
                System.out.printf("%s putting down his %s Chopstick%n", philosopher.getName(), (chopstick == leftChopstick ? "left" : "right"));
                diningTable.putDown(chopstick);
            }
        };
        while (!Thread.currentThread().isInterrupted()) {
            if (attemptsWithoutEating.getAndIncrement() > 500) {
                throw new AssertionError(String.format("%s has starved!", philosopher.getName()));
            }
            System.out.printf("%s attempting to eat%n", philosopher.getName());
            if (philosopher.attemptEat(leftChopstick, rightChopstick, callback)) {
                if (!diningTable.holds(philosopher, leftChopstick, rightChopstick)) {
                    throw new AssertionError("Philosopher attempting to eat but not holding both left and right Chopstick objects.");
                }
                System.out.printf("%s eating...%n", philosopher.getName());
                sleep(200);
                System.out.printf("%s done eating%n", philosopher.getName());
                attemptsWithoutEating.set(0);
                philosopher.doneEating(leftChopstick, rightChopstick, callback);
                sleep(200);
            } else {
                sleep(100);
            }
        }
    }

    private void sleep(int max) {
        try {
            int sleep = random.nextInt(max);
            Thread.sleep(sleep);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
