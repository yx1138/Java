package edu.nyu.cs9053.homework5;

/**
 * User: blangel
 * Date: 9/21/14
 * Time: 5:40 PM
 */
public interface TimeTraveler {

    /**
     * @return the traveler's name
     */
    String getName();

    /**
     * @return the remaining years of the time traveler. If 0, this time traveler can no longer travel through time
     */
    Double getRemainingYearsOfTravel();

    /**
     * @param unit of time
     * @param amount of time
     * @param ahead true if the time travel was in the future and false if it were in the past
     */
    void adjust(Time unit, int amount, boolean ahead);

}
