package edu.nyu.cs9053.homework9.jellybean;

/**
 * User: blangel
 * Date: 10/31/15
 * Time: 12:09 PM
 *
 */
public interface Producer {

    /**
     * Creates a new {@link JellyBean} and places it into {@code into} only if there's available room left within it
     * @param into to place the new {@link JellyBean} if any
     * @return the produced {@link JellyBean} or null if none could be placed
     */
    JellyBean produce(JellyBeanContainer into);

}
