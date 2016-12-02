## Homework 11 - Week 11

### Motivation
* Demonstrate your ability to program using Java IO mechanisms.

### Instructions
* Your task is to create a chat application.
    - There are two classes to implement.  The [BlockingChatter](src/main/java/edu/nyu/cs9053/homework11/BlockingChatter.java) and [NonBlockingChatter](src/main/java/edu/nyu/cs9053/homework11/NonBlockingChatter.java)
        - The `BlockingChatter` will use blocking IO
        - The `NonBlockingChatter` will use non-blocking IO
    - Additionally, you need to add an "Easter Egg" into your application.  Whenever the `BlockingChatter` reads the value `java` from the server it should send back a random line of text from the book [Moby Dick](src/main/resources/Moby%20Dick.txt)
    - To test your solution works, in three separate terminal tabs/windows run the following:
        - Run [ChatServer](src/main/java/edu/nyu/cs9053/homework11/ChatServer.java)
        - Run [Chat](src/main/java/edu/nyu/cs9053/homework11/Chat.java) passing in `blocking`.
        - Run [Chat](src/main/java/edu/nyu/cs9053/homework11/Chat.java) passing in `nonblocking`.
        - You should be able to enter text in one tab/window and see it appear in the other (and echoed by the server).
        - To ensure the Easter Egg works, when the `nonblocking` client types `java` it should then be greated with a random line of text from the book `Moby Dick`. As the `blocking` client will read `java` from the server and then send back the random line of text.
 
### Implementation
* Ensure your code is correct by compiling and testing it
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations
    
    