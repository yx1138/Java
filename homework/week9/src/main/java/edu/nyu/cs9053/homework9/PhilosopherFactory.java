package edu.nyu.cs9053.homework9;

/**
 * User: blangel
 * Date: 11/11/14
 * Time: 8:31 AM
 */
public class PhilosopherFactory {

    public static Philosopher construct(final String name) {
        // TODO - return your implementation of Philosopher
        return new PhilosopherWithDijkstra(name);
    }

    public static Philosopher constructWithWaiter(final Waiter waiter, final String name) {
        // TODO - return your implementation of Philosopher which uses the Waiter
        return new PhilosopherWithWaiter(name,waiter);
    }

    public static Waiter constructWaiter() {
        // TODO - return a new Waiter
        return new Waiter();
    }

}
