package edu.nyu.cs9053.homework9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * User: blangel
 * Date: 11/11/14
 * Time: 7:55 AM
 */
public class DiningTable {

    private final List<Philosopher> philosophers;

    private final List<Chopstick> chopsticks;

    private final ConcurrentMap<Chopstick, Philosopher> owner;

    public DiningTable(List<Philosopher> philosophers, List<Chopstick> chopsticks) {
        if ((philosophers == null) || (philosophers.size() != 5) || (chopsticks == null) || (chopsticks.size() != 5)) {
            throw new IllegalArgumentException("Must have 5 Philosopher objects and 5 Chopstick objects.");
        }
        this.philosophers = philosophers;
        this.chopsticks = chopsticks;
        this.owner = new ConcurrentHashMap<Chopstick, Philosopher>(5, 1.0f);
    }

    public Philosopher getPhilosopher(int index) {
        if ((index < 0) || (index > 4)) {
            throw new IllegalArgumentException();
        }
        return philosophers.get(index);
    }

    /**
     * @param philosopher for which to return the two nearby chopsticks
     * @return a List of two chopsticks, the first element will be the right chopstick
     *         and the second element will be the left chopstick for {@code philosopher}
     */
    public List<Chopstick> getChopsticksNear(Philosopher philosopher) {
        int index = philosophers.indexOf(philosopher);
        List<Chopstick> near = new ArrayList<>();
        switch (index) {
            case 0:
                near.add(chopsticks.get(0));
                near.add(chopsticks.get(1));
                break;
            case 1:
                near.add(chopsticks.get(1));
                near.add(chopsticks.get(2));
                break;
            case 2:
                near.add(chopsticks.get(2));
                near.add(chopsticks.get(3));
                break;
            case 3:
                near.add(chopsticks.get(3));
                near.add(chopsticks.get(4));
                break;
            case 4:
                near.add(chopsticks.get(4));
                near.add(chopsticks.get(0));
                break;
            default:
                throw new AssertionError();
        }
        return near;
    }

    public synchronized void pickup(Philosopher philosopher, Chopstick chopstick) {
        if (owner.containsKey(chopstick)) {
            throw new AssertionError("Attempting to pickup a Chopstick already held by another Philosopher");
        }
        owner.put(chopstick, philosopher);
    }

    public synchronized boolean holds(Philosopher philosopher, Chopstick leftChopstick, Chopstick rightChopstick) {
        return ((owner.get(leftChopstick) == philosopher) && (owner.get(rightChopstick) == philosopher));
    }

    public synchronized void putDown(Chopstick chopstick) {
        owner.remove(chopstick);
    }

}
