package edu.nyu.cs9053.homework3.metadata;

/**
 * User: blangel
 * Date: 8/23/14
 * Time: 11:56 AM
 */
//The class should be puclic so the other class can access to this.
public class FixMeToo {

    private final boolean escape;

    public FixMeToo(boolean escape) {
        this.escape = escape;
    }

    public String analyzeMetadata(String metadata) {
        return escape ? String.format("\"%d\"", metadata) : metadata;
    }

}
