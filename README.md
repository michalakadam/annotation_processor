# Simple custom annotation processor

Program written to master use of reflection API and implementing custom annotation processors using javax.annotation.processing package. Code on branch master invokes methods marked with custom @Run annotation during Runtime using Java reflection API. Code on branch customprocesor implements AnnotationProcessor from javax.annotation.processing package and analyzes code during compile phase. Switch to branch customprocessor to see instructions on how to run it.

### Instructions on running the program using reflection

##### Requirements

Maven minimum 3.5.3
Java minimum 8

##### Instructions

1. Run terminal and navigate to this project's folder

2. Execute 'mvn clean install' command

3. Run app by typing 'java -jar ./tester/target/tester.jar'


