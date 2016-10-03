package edu.nyu.cs9053.homework4.hierarchy;

// Cycad is Deciduous with a Gymnosperm seed 
public  class Cycad extends Tree{
	
	private static final Type type = Type.Deciduous;

	// the number of the leaves
	private final int number_of_leaves ;
	public Cycad(String name, int age,int number_of_leaves){
		super(name,type,age,new Gymnosperm());
		this.number_of_leaves = number_of_leaves;
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
		Cycad that = (Cycad) o;
		if (number_of_leaves != that.number_of_leaves){
			return false;
		}
		return true;
	}
	public  int hashCode(){
		int result = super.hashCode();
		result = result + 7 * number_of_leaves;
		return result;
	}

}