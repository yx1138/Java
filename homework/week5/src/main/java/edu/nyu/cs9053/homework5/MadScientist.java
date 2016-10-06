package edu.nyu.cs9053.homework5;

/**
 * User: blangel
 * Date: 9/21/14
 * Time: 6:01 PM
 */
public class MadScientist {

    private final TimeMachine timeMachine;

    public MadScientist(TimeMachine timeMachine) {
        this.timeMachine = timeMachine;
    }

    public static void main(String[] args) {
        // make a MadScientist / TimeMachine and 3 TimeTraveler implementations
        // experiment on each TimeTraveler
        // a TimeTraveler should always start with 100 years of time travel strength
        // one TimeTraveler implementation should linearly decay (i.e., one year of actual time travel reduces the
        // time traveler's ability by one year)
        // one TimeTraveler implementation should decay double the travel value (i.e., one year of actual time travel reduces
        // the time traveler's ability by two years)
        // one TimeTraveler implementation should have exponential decay with a decay constant inputted by the scientist (see http://en.wikipedia.org/wiki/Exponential_decay)

        // continue to experiment until all the TimeTraveler's have exhausted their ability to travel
    }

    public void experiment(TimeTraveler timeTraveler) {
        // invoke the time-machine and print how much time has passed using a callback and adjust the time traveler's ability to travel
    }


}
