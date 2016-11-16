## Homework 10 - Week 10

### Motivation
* Demonstrate your ability to program using Java concurrency mechanisms (i.e., Threads / ServiceExecutors / latch objects).

### Instructions
* Your task is to create a system which can count the words within a book.
    - There are four classes to implement.  Two implementations of [WordCounter](src/main/java/edu/nyu/cs9053/homework10/WordCounter.java) and two implementations of [FilesWordCounter](src/main/java/edu/nyu/cs9053/homework10/FilesWordCounter.java)
        - I have stubbed out the four implementations with TODOs for you to implement.
        - [ThreadedWordCounter](src/main/java/edu/nyu/cs9053/homework10/ThreadedWordCounter.java)
        - [ExecutorWordCounter](src/main/java/edu/nyu/cs9053/homework10/ExecutorWordCounter.java)
        - [ThreadedFilesWordCounter](src/main/java/edu/nyu/cs9053/homework10/ThreadedFilesWordCounter.java)
        - [ExecutorFilesWordCounter](src/main/java/edu/nyu/cs9053/homework10/ExecutorFilesWordCounter.java)
    - Besides the four implementations you must address the TODO in [Counter](src/main/java/edu/nyu/cs9053/homework10/Counter.java)
        - To address the TODO you only need to modify code within the `count` method.  If you find yourself creating instance variables or anything outside of the `count` method you are doing something wrong.
    - To test your solution works (at least functionally, there is no automated test for thread-safety that will be me and the TA reviewing your code manually):
        - Run [Counter](src/main/java/edu/nyu/cs9053/homework10/Counter.java) passing in values as detailed by it.
 
### Implementation
* Ensure your code is correct by compiling and testing it
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations
* Your code may correctly count the words within the files but may still be incorrect. It must be thread safe as well.
    
### Book Sources
* All book texts came from [Project Gutenberg](https://www.gutenberg.org)
    

    