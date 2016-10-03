package edu.nyu.cs9053.homework4.hierarchy;

// Birch is Deciduous and eudicot with an Angiosperms seed
public  class Birch extends Tree{
	
	private static final Type type = Type.Deciduous;
	private static final boolean IS_EUDICOT = true;

	//the color of the tree
	private final String color;
	public Birch(String name, int age,String color){
		super(name,type,age,new Angiosperms(IS_EUDICOT));
		this.color = color;
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
		Birch that = (Birch) o;
		if (color != null ? !color.equals(that.color) : that.color != null){
			return false;
		}
		return true;
	}
	public  int hashCode(){
		int result = super.hashCode();
		result = result + 7 * color.hashCode();
		return result;
	}
	public boolean isEudicot(){
		return IS_EUDICOT;
	}

}