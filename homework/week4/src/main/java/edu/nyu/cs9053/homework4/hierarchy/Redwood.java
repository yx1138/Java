package edu.nyu.cs9053.homework4.hierarchy;

//Redwood is a sub-type of Conifer and it is Evergreen
public  class Redwood extends Conifer{
	
	private static final Type type = Type.Evergreen;
	// the height of the tree
	private final double height ;
	public Redwood(String name, int age,double height){
		super(name,type,age);
		this.height = height;
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
		Redwood that = (Redwood) o;
		if (height != that.height){
			return false;
		}
		return true;
	}
	public  int hashCode(){
		int result = super.hashCode();
		Double box_height = height;
		result = result + 7 * box_height.hashCode();
		return result;
	}

}