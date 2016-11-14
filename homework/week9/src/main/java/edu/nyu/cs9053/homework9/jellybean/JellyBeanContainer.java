package edu.nyu.cs9053.homework9.jellybean;

import java.util.List;

/**
 * User: blangel
 * Date: 10/31/15
 * Time: 12:30 PM
 *
 */
public class JellyBeanContainer {

    private final List<JellyBean> beans;

    private final int capacity;

    public JellyBeanContainer(List<JellyBean> beans) {
        this.beans = beans;
        this.capacity = beans.size();
    }

    public boolean atCapacity() {
        return (beans.size() == capacity);
    }

    public boolean isEmpty() {
        return beans.isEmpty();
    }

    public void add(JellyBean jellyBean) {
        this.beans.add(jellyBean);
        if (this.beans.size() > capacity) {
            throw new UnsupportedOperationException();
        }
    }

    public JellyBean remove() {
        try {
            return this.beans.remove(0);
        } catch (IndexOutOfBoundsException ioobe) {
            throw new UnsupportedOperationException();
        }
    }

}
