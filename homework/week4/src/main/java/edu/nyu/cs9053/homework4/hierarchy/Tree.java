package edu.nyu.cs9053.homework4.hierarchy;


public abstract class Tree{
	public enum Type{
		Evergreen , Deciduous
	}
	private final String name;

	private final Type type;

	private final int age;
	// decide the seed is enclosed or not .further eudicot or monocot
	private final Seed seed;

	public Tree(String name, Type type, int age, Seed seed){
		this.name = name;
		this.type = type;
		this.age = age;
		this.seed = seed;
	}
	public String getName(){
		return name;
	}
	public Type getType(){
		return type;
	}
	public int getAge(){
		return age;
	}
	public boolean isSeedEnclosed(){
		return seed.getSeedEnclosed();
	}
	public Seed getSeed(){
		return seed;
	}
	public  boolean equals(Object o){
		if (this == o){
			return true;
		}
		if(o == null || getClass() != o.getClass()){
			return false;
		}
		Tree that = (Tree) o;
		if (name != null ? !name.equals(that.name) : that.name != null){
			return false;
		}
		if (type != null ? !type.equals(that.type) : that.type != null){
			return false;
		}
		if ( age != that.age ){
			return false;
		}
		if ( seed != null ? !seed.equals(that.seed) : that.seed != null ){
			return false;
		}
		return true;
	}
	
	public  int hashCode(){
		int result = 0;
		result = 31*(name != null ? name.hashCode() : 0)+ 29 * (type != null ? type.hashCode() : 0) + 23 * age + seed.hashCode();
		return result;
	}
}