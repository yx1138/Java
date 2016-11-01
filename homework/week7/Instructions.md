## Homework 7 - Week 7

### Motivation
* Demonstrate your ability to program using generics in the Java programming language.

### Instructions
* There are four tasks to complete
    - Create the following classes- all of which should implement [Item](src/main/java/edu/nyu/cs9053/homework7/inventory/Item.java) and be located in the same package as it.
        - Book
            - Besides a field for price, has a field named `title`
        - Electronic
        - Softcover - extends `Book`
        - Hardcover - extends `Book`
        - Bookcover
            - Besides a field for price, has a field named `book` which is any type of `Book`
        - Computer - extends `Electronic`
            - Besides a field for price, has a field named `ghz` of type `Double`
        - Camera - extends `Electronic`
        - DigitalCamera - extends `Camera`
            - Besides a field for price, has a field named `zoom` of type `Integer`
    - Create the three print methods in [WarehouseInventoryAuditor](src/main/java/edu/nyu/cs9053/homework7/WarehouseInventoryAuditor.java)
    - Make [Warehouse](src/main/java/edu/nyu/cs9053/homework7/Warehouse.java) use generics.
        - Implement the two copy methods (one of which should call the other).
    - Under the `inventory` subpackage, create 5 more [Item](src/main/java/edu/nyu/cs9053/homework7/inventory/Item.java) classes of your own choice.  Each one of which should use generics (similar to `Bookcover`; i.e., they should have an instance field which is generically typed).

### Implementation
* Ensure your code is correct by compiling and testing it
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lectures
    - Break large functions into multiple functions based on logical organizations
    

    