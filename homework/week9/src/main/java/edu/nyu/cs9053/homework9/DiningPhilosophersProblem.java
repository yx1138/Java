package edu.nyu.cs9053.homework9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: blangel
 * Date: 11/11/14
 * Time: 7:54 AM
 */
public class DiningPhilosophersProblem implements Runnable {

    public static void main(String[] args) {
        boolean useWaiter = ((args != null) && (args.length == 1) && ("waiter".equals(args[0])));
        List<Philosopher> philosophers = new ArrayList<Philosopher>(5);
        List<Chopstick> chopsticks = new ArrayList<Chopstick>(5);
        Waiter waiter = (useWaiter ? PhilosopherFactory.constructWaiter() : null);
        for (int i = 0; i < 5; i++) {
            if (useWaiter) {
		philosophers.add(PhilosopherFactory.constructWithWaiter(waiter, getName(i)));
            } else {
                philosophers.add(PhilosopherFactory.construct(getName(i)));
            }
            chopsticks.add(new Chopstick((i + 1)));
        }
        DiningTable table = new DiningTable(philosophers, chopsticks);
        DiningPhilosophersProblem problem = new DiningPhilosophersProblem(table);
        problem.run();
    }

    private static String getName(int index) {
        switch (index) {
            case 0:
                return "Plato";
            case 1:
                return "Confucius";
            case 2:
                return "Socrates";
            case 3:
                return "Voltaire";
            case 4:
                return "Descartes";
            default:
                throw new IllegalArgumentException();
        }
    }

    private final DiningTable diningTable;

    public DiningPhilosophersProblem(DiningTable diningTable) {
        this.diningTable = diningTable;
    }

    @Override public void run() {
        Random random = new Random();
        PhilosopherRunner runner1 = getRunner(0, random);
        PhilosopherRunner runner2 = getRunner(1, random);
        PhilosopherRunner runner3 = getRunner(2, random);
        PhilosopherRunner runner4 = getRunner(3, random);
        PhilosopherRunner runner5 = getRunner(4, random);
        Thread philosopher1 = new Thread(runner1);
        Thread philosopher2 = new Thread(runner2);
        Thread philosopher3 = new Thread(runner3);
        Thread philosopher4 = new Thread(runner4);
        Thread philosopher5 = new Thread(runner5);
        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();

        while (philosopher1.isAlive()
                && philosopher2.isAlive()
                && philosopher3.isAlive()
                && philosopher4.isAlive()
                && philosopher5.isAlive()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(ie);
            }
        }
        philosopher1.interrupt();
        philosopher2.interrupt();
        philosopher3.interrupt();
        philosopher4.interrupt();
        philosopher5.interrupt();

        throw new AssertionError("Invalid implementation; philosophers should eat infinitely!");
    }

    private PhilosopherRunner getRunner(int index, Random random) {
        Philosopher philosopher = diningTable.getPhilosopher(index);
        List<Chopstick> chopsticks = diningTable.getChopsticksNear(philosopher);
        return new PhilosopherRunner(diningTable, philosopher, chopsticks.get(0), chopsticks.get(1), random);
    }

}
