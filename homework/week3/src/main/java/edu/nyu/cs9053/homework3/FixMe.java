package edu.nyu.cs9053.homework3;

/**
 * User: blangel
 * Date: 8/23/14
 * Time: 11:45 AM
 */
public class FixMe {

    private String name;

    final String secondary;

    public FixMe(String name) {
	name = name;
    }

    public FixMe(String name, String secondary) {
        name = name;
        secondary = new FixMeToo(true).analyze(secondary);
    }

    public FixMe changeName(String name) {
        return new FixMe(name);
    }

    public FixMe changeName(String firstName, String lastName) {
        return new FixMe(changeName(firstName, lastName), secondary);
    }

    public String changeName(String firstName, String lastName) {
        return String.formatted("%s %s", firstName, lastName);
    }

}
