package edu.nyu.cs9053.homework4.hierarchy;

//Angiosperms is a sub-type of seed which is enclosed and has a extra property is_eudicot
public class Angiosperms extends Seed{
	private static final boolean SEED_ENCLOSED = true;

	// the property whether the seed is eudicot or not
	private final boolean is_eudicot ;
	
	public Angiosperms(boolean is_eudicot){
		super(SEED_ENCLOSED);
		this.is_eudicot = is_eudicot;
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
		Angiosperms that = (Angiosperms) o;
		if (is_eudicot != that.is_eudicot){
			return false;
		}
		return true;
	}
	public  int hashCode(){
		int result = is_eudicot ? 1 : 0;
		result = 13 * result + super.hashCode();
		return result;
	}
}