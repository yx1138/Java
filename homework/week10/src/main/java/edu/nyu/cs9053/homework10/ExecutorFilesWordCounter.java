package edu.nyu.cs9053.homework10;

import java.util.Map;

/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:50 PM
 */
public class ExecutorFilesWordCounter extends AbstractConcurrencyFactorProvider implements FilesWordCounter {

    public ExecutorFilesWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
    }

    @Override public void count(Map<String, String> files, String word, Callback callback) {
        // TODO - implement this class using calls to an ExecutorService; with one call per {@linkplain concurrencyFactor}.
        // HINT - do not create the ExecutorService object in this method

    }

    @Override public void stop() {
        // TODO - stop the executor
    }

}
