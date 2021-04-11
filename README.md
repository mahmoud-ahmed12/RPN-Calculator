# Command Line Reverse Polish Notation calculator
A command line calculator which operator follow their operands. <br/> 
For instance to add 3 and 4 together one should write `3 4 +`
Calculator takes input as space Separated line and process it 
printing the content of the stack and so on.

## Sample Input/ Output
Input : `1 2 3 +`  <br/>
Output: `stack: 1 5`

## Features Included
* Addition
* Subtraction
* Multiplication
* Division
* Sqrt
* Undo
* Clear

## Install Instructions
* Install Java 11
* Install maven version at least 3.2
* Run `git clone https://github.com/mahmoud-ahmed12/airwallex-task.git`
* Go to project root directory
* Run `mvn clean install`
* Run the executable jar `java -jar target/airwallex-task-1.0-SNAPSHOT-spring-boot.jar`