## Homework 8 - Week 8

### Motivation
* Demonstrate your ability to program using the Java language's Collection utilities.

### Instructions
* There are three tasks to complete
    - Create the [Multimap](src/main/java/edu/nyu/cs9053/homework8/Multimap.java) interface.  A multi-map is a mapping between a key and a list of values.
        - The interface should have two generic parameters a `K` which is the key and a `V` which is the type of value within a `List`.
        - A declaration of a `Multimap` from `String` to a list of `Integer` should look like `Multimap<String, Integer>`
        - The [Multimap](src/main/java/edu/nyu/cs9053/homework8/Multimap.java) should implement the `Map` interface of the Java collections.
        - In addition to the methods defined within `Map` it should have a method which takes a `K` and a `V` which maps `K` to `V` by adding `V` to the underlying `List`
        - You should create two concrete classes of [Multimap](src/main/java/edu/nyu/cs9053/homework8/Multimap.java) one of which delegates to a `HashMap` implementation which has an `ArrayList` for the `List` implementation and another which delegates to a `TreeMap` implementation and has a `LinkedList` for the `List` implementation.
    - Create the [Sets](src/main/java/edu/nyu/cs9053/homework8/Sets.java) class.
        - Modify the methods to take generic parameters.
        - The `Set union(Set left, Set right)` should return a Set whose elements are all elements in `left` and `right`
        - The `Set intersection(Set left, Set right)` should return a Set whose elements are only those found in both `left` and `right`
        - The `Set symmetricDifference(Set left, Set right)` should return a Set containing all elements that are contained in either `left` or `right` but not in both.
        - The `List<Set> cartesianProduct(List<Set> sets)` should return the [cartesian product](http://en.wikipedia.org/wiki/Cartesian_product) of `sets`
        
        $ Set<String> foos = SetFactory.create("foo1", "foo2");
        $ Set<String> bars = SetFactory.create("bar1", "bar2", "bar3");
        $ List<Set<String>> cartesianProduct = Sets.cartesianProduct(foos, bars);
        $ // cartesianProduct => [{"foo1", "bar1"}, {"foo1", "bar2"}, {"foo1", "bar3"}, {"foo2", "bar1"}, {"foo2", "bar2"}, {"foo2", "bar3"}]
    - Create the [Lists](src/main/java/edu/nyu/cs9053/homework8/Lists.java) class.
        - Modify the method to take generic parameters.
        - The `List reverse(List list)` should return a reversed view of the inputted `list`.

        $ List<String> list = ListFactory.create("foo", "bar", "foos", "bars");
        $ List<String> reversed = Lists.reverse(list);
        $ // reversed = ["bars", "foos", "bar", "foo"]
 
### Implementation
* Ensure your code is correct by compiling and testing it
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations
    

    