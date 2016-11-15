package edu.nyu.cs9053.homework9;
import java.util.concurrent.Semaphore;
/**
 * User: blangel
 * Date: 11/11/14
 * Time: 7:54 AM
 */
public class Chopstick {

    // TODO - change if need be

    private final int numberAroundTable;
    private final Semaphore available ;


    public Chopstick(int numberAroundTable) {
        this.numberAroundTable = numberAroundTable;
        this.available = new Semaphore(1);
    }

    public int getNumberAroundTable() {
        return numberAroundTable;
    }
 	public Semaphore getSemaphore(){
 		return available;
 	}

}
