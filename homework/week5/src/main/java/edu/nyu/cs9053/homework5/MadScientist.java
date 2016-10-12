package edu.nyu.cs9053.homework5;

/**
 * User: blangel
 * Date: 9/21/14
 * Time: 6:01 PM
 */
public class MadScientist {
    private static final double EXPONENT_DECAY_CONSTANT = 10.0d;

    private final TimeMachine timeMachine;

    public MadScientist(TimeMachine timeMachine) {
        this.timeMachine = timeMachine;
    }

    public static void main(String[] args) {

        MadScientist ascientist = new MadScientist(new TimeMachine());

        LinearlyDecayTimeTraveler alinearlydecaytimetraveler = new LinearlyDecayTimeTraveler("Jing");
        DoublyDecayTimeTraveler doublydecaytimetraveler = new DoublyDecayTimeTraveler("Xia");
        ExponentiallyDecayTimeTraveler exponentiallyDecayTimeTraveler = new ExponentiallyDecayTimeTraveler("sherlock",EXPONENT_DECAY_CONSTANT);


        ascientist.experiment(alinearlydecaytimetraveler);
        ascientist.experiment(doublydecaytimetraveler);
        ascientist.experiment(exponentiallyDecayTimeTraveler);

        
        // make a MadScientist / TimeMachine and 3 TimeTraveler implementations
        // experiment on each TimeTraveler
        // a TimeTraveler should always start with 100 years of time travel strength
        // one TimeTraveler implementation should linearly decay (i.e., one year of actual time travel reduces the
        // time traveler's ability by one year)
        // one TimeTraveler implementation should decay double the travel value (i.e., one year of actual time travel reduces
        // the time traveler's ability by two years)
        // one TimeTraveler implementation should have exponential decay with a decay constant inputted by the scientist (see http://en.wikipedia.org/wiki/Exponential_decay)

        // continue to experiment until all the TimeTraveler's have exhausted their ability to travel
    }

    public void experiment(final TimeTraveler timeTraveler) {
        // invoke the time-machine and print how much time has passed using a callback and adjust the time traveler's ability to travel
        //  anonymous classes implementing TimeTravelCallback
        final TimeTravelCallback callback = new TimeTravelCallback(){
            public void leaped(Time unit, int amount, boolean ahead){
                timeTraveler.adjust(unit , amount , ahead);
                switch (unit){
                    case Hours :
                    System.out.printf("TimeTraveler %s: travels to the %s for %d hours .His/Her remaining travel ability is %f years\n",timeTraveler.getName(), ahead ? "future":"past",amount,timeTraveler.getRemainingYearsOfTravel());
                    break;
                    case Days :
                    System.out.printf("TimeTraveler %s: travels to the %s for %d days .His/Her remaining travel ability is %f years\n",timeTraveler.getName(), ahead ? "future":"past",amount,timeTraveler.getRemainingYearsOfTravel());
                    break;
                }
                if(timeTraveler.getRemainingYearsOfTravel() >=0.0d)
                    experiment(timeTraveler);
            }
        };

        timeMachine.travel(timeTraveler , callback);
    }
}
