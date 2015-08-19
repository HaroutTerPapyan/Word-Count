/*
Harout Ter-Papyan
TestWordCount.java
*/

import java.io.*;

public class TestWordCount {
	public static void main(String[] args) throws FileNotFoundException
	{ 
		WordCount wcounter = new WordCount("apple.txt");
		wcounter.start();
		wcounter.printHashTableOrder();
		wcounter.printAlphaOrder();
		wcounter.printFrequencyOrder();
		wcounter.printTopTen();
	}
}


/*
 Test File Input apple.txt

hamster  dog  dog  lion  snake  hamster  dog  fish  pig  monkey    
frog    
dog  fish  pig  fish    
monkey  snake  bird  snake  bear    
bird  dog  monkey  snake  hamster  frog  monkey  frog  tiger    
pig  bird  monkey  frog  cat  frog  dog  cat  fish  frog  cat    
lion  fish  snake  bear  monkey  frog    
dog  bear  frog  fish  


Instructor Test File Output

run:



Hash Table Order Print: 
Number of unique words: 12

monkey	Count: 6	Line List:  1,4,5,5,6,7
frog	Count: 8	Line List:  2,5,5,6,6,6,7,8
hamster	Count: 3	Line List:  1,1,5
fish	Count: 6	Line List:  1,3,3,6,7,8
bird	Count: 3	Line List:  4,5,6
cat	Count: 3	Line List:  6,6,6
snake	Count: 5	Line List:  1,4,4,5,7
bear	Count: 3	Line List:  4,7,8
tiger	Count: 1	Line List:  5
dog	Count: 7	Line List:  1,1,1,3,5,6,8
lion	Count: 2	Line List:  1,7
pig	Count: 3	Line List:  1,3,6



Alphabetic order print: 
Number of unique words: 12

bear	Count: 3	Line List:  4,7,8
bird	Count: 3	Line List:  4,5,6
cat	Count: 3	Line List:  6,6,6
dog	Count: 7	Line List:  1,1,1,3,5,6,8
fish	Count: 6	Line List:  1,3,3,6,7,8
frog	Count: 8	Line List:  2,5,5,6,6,6,7,8
hamster	Count: 3	Line List:  1,1,5
lion	Count: 2	Line List:  1,7
monkey	Count: 6	Line List:  1,4,5,5,6,7
pig	Count: 3	Line List:  1,3,6
snake	Count: 5	Line List:  1,4,4,5,7
tiger	Count: 1	Line List:  5



Frequency order print: 
Number of unique words: 12

frog	Count: 8	Line List:  2,5,5,6,6,6,7,8
dog	Count: 7	Line List:  1,1,1,3,5,6,8
monkey	Count: 6	Line List:  1,4,5,5,6,7
fish	Count: 6	Line List:  1,3,3,6,7,8
snake	Count: 5	Line List:  1,4,4,5,7
pig	Count: 3	Line List:  1,3,6
hamster	Count: 3	Line List:  1,1,5
cat	Count: 3	Line List:  6,6,6
bird	Count: 3	Line List:  4,5,6
bear	Count: 3	Line List:  4,7,8
lion	Count: 2	Line List:  1,7
tiger	Count: 1	Line List:  5



Top Ten
frog	Count: 8	Line List:  2,5,5,6,6,6,7,8
dog	Count: 7	Line List:  1,1,1,3,5,6,8
monkey	Count: 6	Line List:  1,4,5,5,6,7
fish	Count: 6	Line List:  1,3,3,6,7,8
snake	Count: 5	Line List:  1,4,4,5,7
pig	Count: 3	Line List:  1,3,6
hamster	Count: 3	Line List:  1,1,5
cat	Count: 3	Line List:  6,6,6
bird	Count: 3	Line List:  4,5,6
bear	Count: 3	Line List:  4,7,8
Number of Unique Words: 10

BUILD SUCCESSFUL (total time: 0 seconds)
*/