package edu.nyu.cs9053.homework4.hierarchy;

public abstract class Seed{
	//property : the seed is enclosed or not
	private boolean seedEnclosed;

	public Seed(boolean seedEnclosed){
		this.seedEnclosed = seedEnclosed;
	}
	public boolean getSeedEnclosed(){
		return seedEnclosed;
	}
	public boolean equals(Object o){
		if (this == o){
			return true;
		}
		if(o == null || getClass() != o.getClass()){
			return false;
		}
		Seed that = (Seed) o;
		if ( seedEnclosed!=that.seedEnclosed ){
			return false;
		}
		return true;
	}
	public  int hashCode(){
		int result = 17 * (seedEnclosed ? 1 : 0);
		return result;
	}
}