package edu.nyu.cs9053.homework9;
import java.util.concurrent.Semaphore;
public class PhilosopherWithDijkstra implements Philosopher{
	private final String name;

	public PhilosopherWithDijkstra(String name){
		this.name = name;
	}
	public boolean attemptEat(Chopstick left, Chopstick right, Callback callback){
		Chopstick large;
		Chopstick small;
		Semaphore large_available ;
		Semaphore small_available ;
		
		if(left.getNumberAroundTable() < right.getNumberAroundTable()){
			large = right;
			small = left;
			large_available = right.getSemaphore();
			small_available = left.getSemaphore();
		}else{
			large = left;
			small = right;
			large_available = left.getSemaphore();
			small_available = right.getSemaphore();
		}
		try{
			small_available.acquire();
			callback.pickedUpChopstick(small);
			large_available.acquire();
			callback.pickedUpChopstick(large);
		}catch(InterruptedException e){
			return false;
		}
		return true;
	} 
	public void doneEating(Chopstick left, Chopstick right, Callback callback){
		Chopstick large;
		Chopstick small;
		Semaphore large_available ;
		Semaphore small_available ;
		
		if(left.getNumberAroundTable() < right.getNumberAroundTable()){
			large = right;
			small = left;
			large_available = right.getSemaphore();
			small_available = left.getSemaphore();
		}else{
			large = left;
			small = right;
			large_available = left.getSemaphore();
			small_available = right.getSemaphore();
		}
		callback.putDownChopstick(large);
		large_available.release();
		callback.putDownChopstick(small);
		small_available.release();
	}
	public String getName(){
		return name;
	}
}