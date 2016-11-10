package edu.nyu.cs9053.homework9;

/**
 * User: blangel
 * Date: 11/9/14
 * Time: 5:20 PM
 */
public interface Philosopher {

    /**
     * When invoked, the philosopher should attempt to acquire a chopstick.  If the philosopher acquires a
     * chopstick it should call {@linkplain Callback#pickedUpChopstick(Chopstick)}.
     * If it already has acquired both the {@code left} and the {@code right} chopstick then it should return true; otherwise false.
     * When eating is done the {@linkplain #doneEating(Chopstick, Chopstick, Callback)} method will be called on the Philosopher.
     * @param left chopstick
     * @param right chopstick
     * @param callback to be invoked by this method if the philosopher is able to acquire a chopstick and/or eat.
     */
    boolean attemptEat(Chopstick left, Chopstick right, Callback callback);

    /**
     * Invoked to indicate the Philosopher is done eating.  The philosopher should release the {@code left} and {@code right}
     * Chopsticks so that other philosophers can eat.
     * @param left chopstick
     * @param right chopstick
     * @param callback to be invoked by this method to put down both {@code left} and {@code right} Chopstick objects.
     */
    void doneEating(Chopstick left, Chopstick right, Callback callback);

    /**
     * @return the name of the philosopher
     */
    String getName();

}
