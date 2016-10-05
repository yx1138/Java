package edu.nyu.cs9053.homework4.hierarchy;

// Conifer is sub-type of the Tree with seed of Gymnosperm
public abstract class Conifer extends Tree{

	public Conifer(String name, Type type,int age){
		super(name,type,age,new Gymnosperm());
	}
	public boolean equals(Object o){
		if (this == o){
			return true;
		}
		if(o == null || getClass() != o.getClass()){
			return false;
		}
		if ( !super.equals(o)){
			return false;
		}
		return true;
	}
	public  int hashCode(){
		int result = super.hashCode();
		return result;
	}
}