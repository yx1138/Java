package edu.nyu.cs9053.homework10;

/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:33 PM
 */
public class ExecutorWordCounter extends AbstractConcurrencyFactorProvider implements WordCounter {

    public ExecutorWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
    }

    @Override public void count(String fileContents, String word, Callback callback) {
        // TODO - implement this class using calls to an ExecutorService; one call per {@link #concurrencyFactor}
        // HINT - break up {@linkplain fileContents} and distribute the work across the calls
        // HINT - do not create the ExecutorService object in this method
    }

    @Override public void stop() {
        // TODO - stop the executor
    }
}
