## Homework 5 - Week 5

### Motivation
* Demonstrate your ability to program using interfaces and inner classes in the Java programming language.

### Instructions
* There are two tasks to complete
    - Implement Time Travel!
        - Implement [MadScientist](src/main/java/edu/nyu/cs9053/homework5/MadScientist.java) as detailed by its comments
        - Use anonymous classes to implement [TimeTravelCallback](src/main/java/edu/nyu/cs9053/homework5/TimeTravelCallback.java) when invoked by the [MadScientist](src/main/java/edu/nyu/cs9053/homework5/MadScientist.java) when using her [TimeMachine](src/main/java/edu/nyu/cs9053/homework5/TimeMachine.java)
        - All implementations of [TimeTraveler](src/main/java/edu/nyu/cs9053/homework5/TimeTraveler.java) start with 100 years of time traveling ability
            - Make an implementation of [TimeTraveler](src/main/java/edu/nyu/cs9053/homework5/TimeTraveler.java) which linearly decays (one year of time travel results in one year of time travel ability loss)
            - Make an implementation of [TimeTraveler](src/main/java/edu/nyu/cs9053/homework5/TimeTraveler.java) which decays doubly (one year of time travel results in two years of time travel ability loss)
            - Make an implementation of [TimeTraveler](src/main/java/edu/nyu/cs9053/homework5/TimeTraveler.java) which exponentially decays with a decay constant passed into its constructor; see [wiki](http://en.wikipedia.org/wiki/Exponential_decay)
    - Fix the leaky [Faucet](src/main/java/edu/nyu/cs9053/homework5/memory/Faucet.java) such that you eliminate the inner class leak.

### Implementation
* Ensure your code is correct by compiling and testing it
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations
    

    