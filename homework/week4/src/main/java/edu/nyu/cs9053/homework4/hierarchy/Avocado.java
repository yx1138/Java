package edu.nyu.cs9053.homework4.hierarchy;

//Avocado is Evergreen and eudicot with a Angiosperms seed
public  class Avocado extends Tree{
	
	private static final Type type = Type.Evergreen;
	private static final boolean IS_EUDICOT = true;

	// the number of the fruit
	private final int number_of_fruit;
	
	public Avocado(String name, int age,int number_of_fruit){
		super(name,type,age,new Angiosperms(IS_EUDICOT));
		this.number_of_fruit = number_of_fruit;
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
		Avocado that = (Avocado) o;
		if (number_of_fruit != that.number_of_fruit){
			return false;
		}
		return true;
	}
	public  int hashCode(){
		int result = super.hashCode();
		result = result + 7 * number_of_fruit;
		return result;
	}
	public boolean isEudicot(){
		return IS_EUDICOT;
	}

}