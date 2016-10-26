package edu.nyu.cs9053.homework7;

/**
 * User: blangel
 * Date: 10/13/14
 * Time: 1:57 PM
 */
public class Warehouse {

    private static void copy(Bin from, Bin into) {
	// TODO - copy values in 'from' to 'into'
    }

    // TODO - implement such that the warehouse can hold any Bin of Item type

    private final Bin items;

    public Warehouse(Bin items) {
        this.items = items;
    }

    public Bin getItems() {
        return items;
    }

    public Warehouse copy() {
        // TODO - make a new Bin copying the values from `items` into a new Bin using the 'copy' method below
        // TODO - change to return a copied bin
        return null;
    }

}
