package edu.nyu.cs9053.homework8;

import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * User: blangel
 * Date: 10/14/14
 * Time: 6:47 PM
 */
public class Sets {


    public static <T> Set<T> union(Set<T> left, Set<T> right) {
        Set result = new LinkedHashSet<T>();
        result.addAll(left);
        Iterator<T> iterator = right.iterator();
        while (iterator.hasNext()){
            T target = iterator.next();
            if(!left.contains(target)){
                result.add(target);
            }
        }
        return result;
    }


    public static <T> Set<T> intersection(Set<T> left, Set<T> right) {
	    Set result = new LinkedHashSet<T>();
        Iterator<T> iterator = left.iterator();
        while (iterator.hasNext()){
            T target = iterator.next();
            if(right.contains(target)){
                result.add(target);
            }
        }
        return result;
    }

    public static <T> Set<T> symmetricDifference(Set<T> left, Set<T> right) {
	   Set result = union(left,right);
       Set temp = intersection(left,right);
       result.removeAll(temp);
       return result;
    }

    public static <T> List<Set<T>> cartesianProduct(List<Set<T>> sets) {
        List<Set<T>> resultLists = new ArrayList<Set<T>>();
        if (sets.size() == 0) {
            resultLists.add(new LinkedHashSet<T>());
            return resultLists;
        } else {
            Set<T> firstSet = sets.get(0);
            List<Set<T>> remainingSets = cartesianProduct(sets.subList(1, sets.size()));
            for (T item : firstSet) {
                for (Set<T> remainingSet : remainingSets) {
                     LinkedHashSet<T> resultList = new LinkedHashSet<T>();
                     resultList.add(item);
                     resultList.addAll(remainingSet);
                     resultLists.add(resultList);
                    }
                }
            }
        return resultLists;
    }


}