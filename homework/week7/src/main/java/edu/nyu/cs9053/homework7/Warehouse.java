package edu.nyu.cs9053.homework7;
import edu.nyu.cs9053.homework7.inventory.Item;
import java.util.Iterator;
/**
 * User: blangel
 * Date: 10/13/14
 * Time: 1:57 PM
 */
public class Warehouse<T extends Item> {

    private static void copy(Bin from, Bin into) {
        if(from == null || into == null ) return;
        Iterator itemlist = from.iterator();
        while(itemlist.hasNext()){
            into.add(itemlist.next());
        }
	// TODO - copy values in 'from' to 'into'
    }

    // TODO - implement such that the warehouse can hold any Bin of Item type

    private final Bin<T> items;

    public Warehouse(Bin<T> items) {
        this.items = items;
    }

    public Bin<T> getItems() {
        return items;
    }

    public Warehouse<T> copy() {
        Bin<T> newitems = new Bin<T>();
        copy(items,newitems);
        // TODO - make a new Bin copying the values from `items` into a new Bin using the 'copy' method below
        // TODO - change to return a copied bin
        return new Warehouse<T>(newitems);
    }

}
