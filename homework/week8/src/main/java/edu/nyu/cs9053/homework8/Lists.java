package edu.nyu.cs9053.homework8;

import java.util.List;
import java.util.Collections;

/**
 * User: blangel
 * Date: 10/14/14
 * Time: 6:47 PM
 */
public class Lists {

    public static <T>  List<T> reverse(List<T> list) {
    	
    	Collections.reverse(list);
    	return list;
    }
    
}
