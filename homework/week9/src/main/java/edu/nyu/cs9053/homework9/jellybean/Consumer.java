package edu.nyu.cs9053.homework9.jellybean;

/**
 * User: blangel
 * Date: 10/31/15
 * Time: 12:09 PM
 *
 */
public interface Consumer {

    /**
     * Removes a {@link JellyBean} from {@code from} only if there's beans within it.
     *
     * @param from to extract a {@link JellyBean} if any
     * @return the extracted {@link JellyBean} or null if none could be extracted
     */
    JellyBean consume(JellyBeanContainer from);

}
