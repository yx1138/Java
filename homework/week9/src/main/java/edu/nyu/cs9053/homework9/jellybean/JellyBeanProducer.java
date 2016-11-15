package edu.nyu.cs9053.homework9.jellybean;
import java.util.Random;
public class JellyBeanProducer implements Producer{
	public JellyBean produce(JellyBeanContainer into){
		synchronized(into) {
        	if(!into.atCapacity()){
        		Random random = new Random();
        		Flavor[] flavors = Flavor.values();
        		JellyBean re= new JellyBean(flavors[random.nextInt(flavors.length)]);
        		into.add(re);
        		return re;
        	}
        	else return null;
    	}
	}
}