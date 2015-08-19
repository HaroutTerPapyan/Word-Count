/*
Harout Ter-Papyan
WordCount.java
*/

import java.io.*;
import java.util.*;

public class WordCount {
    //private fields, including your Hashmap variable
    
    Scanner read;
    WordInfo word;
    HashMap<String, WordInfo> hMap = new HashMap<String, WordInfo>();
    Map sortedMap = new TreeMap(hMap);
    ArrayList<WordInfo> hashList = new ArrayList<WordInfo>();
    int uniqueWords = 0;
    
    public WordCount(String inFileName) throws FileNotFoundException {
        try {
            read = new Scanner(new File(inFileName));
            start();
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    
    public void start() {
        Scanner line;
        String aWord;
        int lineNum = 1;
        
        while (read.hasNextLine()) {
            
            line = new Scanner(read.nextLine());
            
            while(line.hasNext()) {
                aWord = line.next();
                if(hMap.containsKey(aWord)) {
                    word = hMap.get(aWord);
                    word.AddLine(lineNum);
                    word.count++;
                }
                else {
                    word = new WordInfo(aWord, lineNum);
                    hMap.put(aWord, word);
                    uniqueWords++;
                }
            }
            lineNum++;
        }
    }
    
    public void printHashTableOrder() {
        System.out.println("\n\n\nHash Table Order Print: ");
        System.out.println("Number of unique words: " + uniqueWords + "\n");
        
        Iterator rep = hMap.entrySet().iterator();
        
        while(rep.hasNext()) {
            Map.Entry entry = (Map.Entry) rep.next();
            String key = (String)entry.getKey();
            WordInfo wInfo = (WordInfo)entry.getValue();
            System.out.println(wInfo);
        }            
    }
    
    public void printAlphaOrder() {

        System.out.println("\n\n\nAlphabetic order print: ");
        System.out.println("Number of unique words: " + uniqueWords + "\n");
        
        Map sortedMap = new TreeMap(hMap);
	Iterator rep = sortedMap.entrySet().iterator();
        
	while(rep.hasNext()){
            Map.Entry entry = (Map.Entry) rep.next();
	    String key = (String)entry.getKey();
	    WordInfo wInfo = (WordInfo)entry.getValue();
            
	    if(hashList.isEmpty()){
                hashList.add(wInfo);	
	    }
            
	    else {
	    	int i = 0;
	    	while(i < hashList.size() && 
                               hashList.get(i).getCount() > wInfo.getCount()){
	    		i++;
	    	}
                
	    	hashList.add(i, wInfo);
	    }    
	    System.out.println(wInfo);
	}
    }
    
    public void printFrequencyOrder() {
        System.out.println("\n\n\nFrequency order print: ");
        System.out.println("Number of unique words: " + uniqueWords + "\n");
        
        for(int i = 0 ; i < hashList.size(); i++){
            System.out.println(hashList.get(i));
	}
        
    }
    
    public void printTopTen() {
        System.out.println("\n\n\nTop Ten Print\n");
        uniqueWords = 0;

        for(int i = 0; i < 10; i++){
            System.out.println(hashList.get(i));
            while(i >= 9){
            if(hashList.get(10).getCount() == hashList.get(i).getCount())
                System.out.println(hashList.get(i));
            else
                break;
            i++;
            uniqueWords++;
            }
            uniqueWords++;
	}
        System.out.println("\nNumber of Unique Words In "
                + "Top Ten: " + uniqueWords + "\n");
    }

}

class WordInfo {
    String aWord;
    int count;
    ArrayList<Integer> lineList;
    
    public WordInfo(String newWord, int line) {
        aWord = newWord;
        count = 1;
        lineList = new ArrayList<Integer>();
        lineList.add(line);
    }

    public void AddLine(int line) {
        lineList.add(line);
    }
    
    public String lineList() {
        String print = "" + lineList.get(0);
        if(lineList.size() > 1) {
            for (int i = 1; i < lineList.size(); i++) {
                print += "," + lineList.get(i);
            }
        }
        return print;
    }
    
    public String getWord() {
        return aWord;
    }
    
    public int getCount() {
        return count;
    }
    
    public String toString() {
        String word = aWord;
        word += "  Count: " + count;
        word += "  Line List: " + lineList();
        return word;
    }
}