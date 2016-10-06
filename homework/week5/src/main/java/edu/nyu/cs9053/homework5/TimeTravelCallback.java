package edu.nyu.cs9053.homework5;

/**
 * User: blangel
 * Date: 9/21/14
 * Time: 5:36 PM
 */
public interface TimeTravelCallback {

    /**
     * Invoked after time traveling is complete.
     * @param unit of time traveled
     * @param amount of time (in {@code unit}) traveled
     * @param ahead true if the time travel went into the future or false if it went into the past
     */
    void leaped(Time unit, int amount, boolean ahead);

}
