package edu.nyu.cs9053.homework8;
import java.util.List;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Set;
import java.util.Map;

public class MultimapOnTreeMap<K,V> implements Multimap<K,V>{
	private TreeMap<K,List<V>> map;
	
	public MultimapOnTreeMap(){
		this.map = new TreeMap<K,List<V>>();
	}
	public List<V> getItems(K key){
		return map.get(key);
	}
	public  boolean putItem(K key, V value){
		List<V> tem = map.remove(key);
		if(tem==null){
			tem = new LinkedList<V>();
		}
		tem.add(value);
		boolean re = false;
		if(map.put(key,tem)!=null){
			re = true;
		}
		return  re;
	}
	public Set<Map.Entry<K,List<V>>> entrySet(){
		return map.entrySet();
	}
	public Collection<List<V>> values(){
		return map.values();
	}
	public Set<K> keySet(){
		return map.keySet();
	}
	public void clear(){
		map.clear();
	}
	public void putAll(Map<? extends K,? extends List<V>> m){
		map.putAll(m);
	}
	public List<V> remove(Object key){
		return map.remove(key);
	}
	public List<V> put(K key, List<V> values){
		return map.put(key,values);
	}
	public List<V> get(Object key){
		return map.get(key);
	}
	public boolean containsValue(Object value){
		return map.containsValue(value);
	}
	public boolean containsKey(Object key){
		return map.containsKey(key);
	}
	public boolean isEmpty(){
		return map.isEmpty();
	}
	public int size(){
		return map.size();
	}
}