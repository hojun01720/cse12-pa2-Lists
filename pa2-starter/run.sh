javac -cp ".;lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar" src/*.java

java -cp ".;lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore src.$1