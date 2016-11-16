package edu.nyu.cs9053.homework10;

/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:16 PM
 */
public class ThreadedWordCounter extends AbstractConcurrencyFactorProvider implements WordCounter {

    public ThreadedWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
    }

    @Override public void count(String fileContents, String word, Callback callback) {
        // TODO - implement this class using Thread objects; one Thread per {@link #concurrencyFactor}
        // HINT - break up {@linkplain fileContents} and distribute the work across the threads
        // HINT - do not create the Thread objects in this method
    }

    @Override public void stop() {
        // TODO - stop the threads
    }

}
