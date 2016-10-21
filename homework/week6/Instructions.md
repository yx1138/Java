## Homework 6 - Week 6

### Motivation
* Demonstrate your ability to program using exceptions, annotations, regular expressions and debug Java programs.

### Instructions
* There is one task to complete - stop the epidemic!
    - Compile code
    - Run `java edu.nyu.cs9053.homework6.SpreadEpidemic YOUR_NET_ID` which starts the epidemic
        - where `YOUR_NET_ID` is your NYU NetID
    - Recompile code
    - Run `java edu.nyu.cs9053.homework6.CenterDiseaseControl YOUR_NET_ID` debugging it to figure out why it is not curing the diseases.
        - where `YOUR_NET_ID` is your NYU NetID
    - Fix the issues and rerun `java edu.nyu.cs9053.homework6.CenterDiseaseControl YOUR_NET_ID` until it prints:
        - `Congrats! You cured the epidemic!`
* Note, for this homework to be valid you must also properly provide the following files:
    - a `compile.sh` file located in the same directory as this file `Instructions.md`. This file must correctly compile your code using the `javac` command
    - a `execute.sh` file located in the same directory as this file `Instructions.md`. This file must correctly invoke the CenterDiseaseControl main method; i.e. `java edu.nyu.cs9053.homework6.CenterDiseaseControl YOUR_NET_ID`
    - a `net.id` file located in the same directory as this file `Instructions.md`. This file must contain `YOUR_NET_ID` as used in the `execute.sh`

### Implementation
* Ensure your code is correct by compiling and testing it
* The only changes you'll need to make are to the classes `Vaccine`, `Infection` and `CenterDiseaseControl`
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations
    

    