## Homework 3 - Week 3

### Motivation
* Demonstrate your ability to program in an object-orientated fashion within the Java programming language

### Instructions
* There are two tasks to complete
    - Fix all compilation errors within the [FixMe](src/main/java/edu/nyu/cs9053/homework3/FixMe.java) class (and dependent classes) and ensure it is coded to standards outlined in lecture.
    - Create classes (they do not currently exist) [DanceCat](src/main/java/edu/nyu/cs9053/homework3/dance/DanceCat.java) and [DanceMove](src/main/java/edu/nyu/cs9053/homework3/dance/DanceMove.java) according to the instructions below.
        - You **must not** modify classes [DanceMagic](src/main/java/edu/nyu/cs9053/homework3/dance/DanceMagic.java) and [DanceOff](src/main/java/edu/nyu/cs9053/homework3/dance/DanceOff.java)

### Implementation
* Ensure your code is correct by compiling and testing it
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations

### DanceCat and DanceMove Instructions
* Create a `DanceCat` class placed in [directory](src/main/java/edu/nyu/cs9053/homework3/dance).
* Create a `DanceMove` class placed in [directory](src/main/java/edu/nyu/cs9053/homework3/dance).
* The `DanceCat` class needs the following constructors
    - One taking `String unparsedMoves` and `String[] idealMoves`
       - This should parse `unparsedMoves` and call the second constructor
       - Note, parsing `unparsedMoves` should always create an array with 18 elements, if the `unparsedMoves` is less than 18, put the empty String [ `""` ] as a placeholder.
    - Second taking `String[] moves` and `String[] idealMoves`
       - This should create `DanceMove` objects and pass to the third constructor
    - Third taking `DanceMove[] danceMoves`
       - This should delegate to the fourth with a default name (either a single default or one randomly selected between some number of default names).
    - Fourth taking `String name` and `DanceMove[] danceMoves`
* The `DanceCat` class should have two instance variables
    - `String name`
    - `DanceMove[] danceMoves`
* The `DanceCat` class should have the following three instance methods
    - a getter returning the `name`
    - a getter returning the `danceMoves`
    - a method named `getNumberOfCorrectMoves` which counts the number of correct moves (see `correctMove` in `DanceMove` below) and returns the value as an `int`
* The `DanceCat` class should have a static method returning a value between 0 - 100 which controls the competitor cat's skill level
    - it returns type `int`
    - Note, `DanceCat` will likely have other static methods to assist in parsing moves.
* The `DanceMove` class should have a single constructor taking `String idealMove` and `String userMove`
* The `DanceMove` class should have two instance variables
    - `String idealMove`
    - `String userMove`
* The `DanceMove` class should have the following three instance methods
    - a getter returning the `idealMove`
    - a getter returning the `userMove`
    - a method which determines is the user move equals the ideal move, returning a boolean result and named `correctMove`
* Enjoy your dancing cats!
    - Run via main method in `edu.nyu.cs9053.homework3.dance.DanceOff`

### Issues
* Output will not be colored in lame terminal (i.e., Windows machines without running via Cygwin)
* Invoke `java` from this directory; i.e., week3, when testing.