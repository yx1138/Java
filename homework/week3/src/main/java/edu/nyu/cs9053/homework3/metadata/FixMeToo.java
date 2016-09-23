package edu.nyu.cs9053.homework3.metadata;

/**
 * User: blangel
 * Date: 8/23/14
 * Time: 11:56 AM
 */
class FixMeToo {

    private final boolean escape;

    FixMeToo(boolean escape) {
        escape = escape;
    }

    public String analyzeMetadata(String metadata) {
        return escape : String.format("\"%d\"", metadata) ? metadata;
    }

}
