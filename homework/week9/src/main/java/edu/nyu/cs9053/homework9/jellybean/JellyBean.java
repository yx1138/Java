package edu.nyu.cs9053.homework9.jellybean;

/**
 * User: blangel
 * Date: 10/31/15
 * Time: 12:06 PM
 */
public class JellyBean {

    private final Flavor flavor;

    public JellyBean(Flavor flavor) {
        this.flavor = flavor;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    @Override public String toString() {
        return String.format("JellyBean{%s}", flavor.name());
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JellyBean jellyBean = (JellyBean) o;
        return (flavor == null ? jellyBean.flavor == null : flavor.equals(jellyBean.flavor));
    }

    @Override public int hashCode() {
        return flavor != null ? flavor.hashCode() : 0;
    }
}
