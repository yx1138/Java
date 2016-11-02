package edu.nyu.cs9053.homework7;
import edu.nyu.cs9053.homework7.inventory.*;
import java.util.Iterator;
/**
 * User: blangel
 * Date: 10/13/14
 * Time: 1:58 PM
 */
public class WarehouseInventoryAuditor {

    // TODO - create a method to print the individual prices of a Bin of any Item type
    public void printItem(Bin<? extends Item> items){
    	if(items == null)
    		return;
    	Iterator<? extends Item> itemlist = items.iterator();
    	while (itemlist.hasNext()){
    		System.out.println(itemlist.next().getPrice());
    	}
    }
    public void printElectronic(Bin<? extends Electronic> items){
    	if(items == null)
    		return;
    	Iterator<? extends Electronic> itemlist = items.iterator();
    	while (itemlist.hasNext()){
    		System.out.println(itemlist.next().getPrice());
    	}
    }
    public void printBook(Bin<? extends Book> items){
    	if(items == null)
    		return;
    	Iterator<? extends Book> itemlist = items.iterator();
    	while (itemlist.hasNext()){
    		System.out.println(itemlist.next().getPrice());
    	}
    }


    // TODO - create a method to print the individual prices of a Bin of any Electronic types

    // TODO - create a method to print the individual prices of a Bin of any Book types

}
