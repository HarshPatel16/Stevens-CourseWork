/***
 * Assignment : Homework Assigment 6
 * Name: Harsh Patel
 * Course: CS-570
 */

import java.io.*;
import java.util.*;

public class Anagrams {
    /**
	 * Data primes is initialized as array of first 26 primes.
	 */
	final Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	Map<Character, Integer> letterTable;
	Map<Long, ArrayList<String>> anagramTable;

    /**
	 * This is a constructor for the class Anagrams.
	 * It helps to initialize the buildLetterTable and anagramTable.
	 */
	public Anagrams() 
	{
		buildLetterTable();
		anagramTable=new HashMap<Long,ArrayList<String>>();
	}

	/**
	 * Constructs a table of letters "a"-"z" and their corresponding prime values.
	 */
    private void buildLetterTable() {
	    letterTable= new HashMap<Character,Integer>();
	    Character[] alphabets= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	    for(int i = 0; i < 26; i++) 
			letterTable.put(alphabets[i], primes[i]);
	}
	
	/**
	* Adds a word to the anagramTable. Checks if the table already contains the value and then adds the provided string if it does. If it doesn't, adds a string and a corresponding hashcode to the table.
	* @param s Takes in a word to be added to the anagramTable.
	*/
	private void addWord(String s) throws IllegalArgumentException {	
		if(s == null || s.length() == 0) 
			throw new IllegalArgumentException();
		Long hashCode = myHashCode(s);
		if(anagramTable.containsKey(hashCode))
			anagramTable.get(hashCode).add(s);
		else {
			ArrayList<String> a = new ArrayList<String>();
			a.add(s);
			anagramTable.put(hashCode, a);
		}
	}

	/**
	 * Generates a hashcode for a provided string using letterTable.
	 * @param s String to generate hashcode for.
	 * @return Long returned of value of hashcode.
	 */
	private Long myHashCode(String s) throws IllegalArgumentException {
		if(s==null) 
		{
			throw new NullPointerException("The String is Empty");
		}
		
		long hashCode = 1;
		
		for(int i = 0; i < s.length(); i++) 
		{
			Character ch = s.toLowerCase().charAt(i);
			hashCode = hashCode * letterTable.get(ch);
		}
		return hashCode;
	}

	/**
	 * Processes the file of the provided title in the local directory.
	 * @param s String name of file to be parsed.
	 * @throws IOException if file is not in directory.
	 */
	private void processFile(String s) throws IOException {
		FileInputStream fStream = new FileInputStream(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
       	String strLine;
       	while((strLine = br.readLine()) != null) {
			this.addWord(strLine);
		}
		br.close();
	}
	
	/**
	 * This function gets the entry of the most number of anagrams with their key and value pair.
	 */
	private ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries() {
		ArrayList<Map.Entry<Long,ArrayList<String>>> lists = new ArrayList<>(); 
		int max = 0;
		for (Map.Entry<Long,ArrayList<String>> entry : anagramTable.entrySet()) {
		  if(entry.getValue().size() > max) {
				lists.clear();
				lists.add(entry);
				max = entry.getValue().size();
			} 
		  else if(entry.getValue().size() == max)
				lists.add(entry);
		}
		 return lists;	 
	}

	/**
	 * Main method to test the code.
	 */
	public static void main(String[] args) {
		Anagrams a = new Anagrams();
		final long startTime = System.nanoTime();
		try {
			a.processFile ("words_alpha.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = a.getMaxEntries ();
		long hashCode = maxEntries.get(0).getKey();
		int length = maxEntries.get(0).getValue().size();
		final long estimatedTime = System.nanoTime() - startTime ;
		final double seconds = ((double)estimatedTime/1000000000);
		System.out.println("Elapsed Time : "+ seconds);
		System.out.println("Key of max anagrams: "+ hashCode);
		System.out.println("List of max anagrams: " + maxEntries.get(0).getValue());
		System.out.println("Length of list of max anagrams : "+ length);
	}

}
