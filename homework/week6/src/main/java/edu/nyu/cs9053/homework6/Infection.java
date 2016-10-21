package edu.nyu.cs9053.homework6;

/**
 * User: blangel
 * Date: 10/5/14
 * Time: 8:16 PM
 */
public @interface Infection {

    /**
     * @return the disease with which the annotation object is infected
     */
    Disease cause();

}
