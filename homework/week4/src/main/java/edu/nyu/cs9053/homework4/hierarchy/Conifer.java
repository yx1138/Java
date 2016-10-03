package edu.nyu.cs9053.homework4.hierarchy;

// Conifer is sub-type of the Tree with seed of Gymnosperm
public abstract class Conifer extends Tree{

	public Conifer(String name, Type type,int age){
		super(name,type,age,new Gymnosperm());
	}
}