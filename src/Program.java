import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashTable my_table = new HashTable();
		ArrayList<Word> wordsCreated = new ArrayList<Word>();
		double[] fillFactor = new double[5];
		
		String msg = "Please enter the name of a file: ";
		String fail_msg = "Invalid file name, please try again.";
		
		// read in the file
		File file = getInput(msg, fail_msg); 
		try {
			Scanner scan = new Scanner(file);
			// ~*~ HASH 1 ~*~
			my_table = new HashTable();
			wordsCreated = new ArrayList<Word>();
			while (scan.hasNext()) {
				String word = scan.next(); 
				word = word.toLowerCase();
				word = removeSymbols(word);
				if (word.contains("-")) {
					String[] words = word.split("-");
					for (String s : words) {
						if (!isDigit(s)) {
							// add to list
							my_table.addWord1(s);
							Word newWord = new Word(s);
							addToCreatedWords(newWord, wordsCreated);
						}
					}
				} else {
					if (!isDigit(word)) {
						// add to list
						my_table.addWord1(word);
						Word newWord = new Word(word);
						addToCreatedWords(newWord, wordsCreated);
					}
				} // end if/else
			} // end while loop
			double count = my_table.getCellCount();
			double table_size = my_table.getTableSize();
			fillFactor[0] = count/table_size;
			
			scan.close(); 
			scan = new Scanner(file);
			
			// ~*~ HASH 2 ~*~
			my_table = new HashTable();
			wordsCreated = new ArrayList<Word>();
			while (scan.hasNext()) {
				String word = scan.next(); 
				word = word.toLowerCase();
				word = removeSymbols(word);
				if (word.contains("-")) {
					String[] words = word.split("-");
					for (String s : words) {
						if (!isDigit(s)) {
							// add to list
							my_table.addWord2(s);
							Word newWord = new Word(s);
							addToCreatedWords(newWord, wordsCreated);
						}
					}
				} else {
					if (!isDigit(word)) {
						// add to list
						my_table.addWord2(word);
						Word newWord = new Word(word);
						addToCreatedWords(newWord, wordsCreated);
					}
				} // end if/else
			} // end while loop
			count = my_table.getCellCount();
			fillFactor[1] = count/table_size;
			
			scan.close();
			scan = new Scanner(file);
			
			// ~*~ HASH 3 ~*~
			my_table = new HashTable();
			wordsCreated = new ArrayList<Word>();
			while (scan.hasNext()) {
				String word = scan.next(); 
				word = word.toLowerCase();
				word = removeSymbols(word);
				if (word.contains("-")) {
					String[] words = word.split("-");
					for (String s : words) {
						if (!isDigit(s)) {
							// add to list
							my_table.addWord3(s);
							Word newWord = new Word(s);
							addToCreatedWords(newWord, wordsCreated);
						}
					}
				} else {
					if (!isDigit(word)) {
						// add to list
						my_table.addWord3(word);
						Word newWord = new Word(word);
						addToCreatedWords(newWord, wordsCreated);
					}
				} // end if/else
			} // end while loop
			count = my_table.getCellCount();
			fillFactor[2] = count/table_size;
			
			scan.close();
			scan = new Scanner(file);
			
			// ~*~ HASH 4 ~*~
			my_table = new HashTable();
			wordsCreated = new ArrayList<Word>();
			while (scan.hasNext()) {
				String word = scan.next(); 
				word = word.toLowerCase();
				word = removeSymbols(word);
				if (word.contains("-")) {
					String[] words = word.split("-");
					for (String s : words) {
						if (!isDigit(s)) {
							// add to list
							my_table.addWord4(s);
							Word newWord = new Word(s);
							addToCreatedWords(newWord, wordsCreated);
						}
					}
				} else {
					if (!isDigit(word)) {
						// add to list
						my_table.addWord4(word);
						Word newWord = new Word(word);
						addToCreatedWords(newWord, wordsCreated);
					}
				} // end if/else
			} // end while loop
			count = my_table.getCellCount();
			fillFactor[3] = count/table_size;
			
			scan.close();
			scan = new Scanner(file);
			
			// ~*~ HASH 5 ~*~
			my_table = new HashTable();
			wordsCreated = new ArrayList<Word>();
			while (scan.hasNext()) {
				String word = scan.next(); 
				word = word.toLowerCase();
				word = removeSymbols(word);
				if (word.contains("-")) {
					String[] words = word.split("-");
					for (String s : words) {
						if (!isDigit(s)) {
							// add to list
							my_table.addWord5(s);
							Word newWord = new Word(s);
							addToCreatedWords(newWord, wordsCreated);
						}
					}
				} else {
					if (!isDigit(word)) {
						// add to list
						my_table.addWord5(word);
						Word newWord = new Word(word);
						addToCreatedWords(newWord, wordsCreated);
					}
				} // end if/else
			} // end while loop
			count = my_table.getCellCount();
			fillFactor[4] = count/table_size;
			
			scan.close();
			scan = new Scanner(file);
		
			// will print last run
			Collections.sort(wordsCreated, new CustomComparator());
			StringBuilder sb = new StringBuilder(); 
			sb.append("\nFrequency counts: \n");
			for (Word w : wordsCreated) {
				sb.append(w.getWord() + ": " + w.getCount() + " \n");
			}
			
			System.out.println(sb.toString());
			File outFile = new File(file + ".out.txt");
			PrintWriter stream = new PrintWriter(outFile);
			stream.write(sb.toString());
			stream.close();
			
			System.out.println("Fill factors: ");
			for (int i = 0; i < 5; i++) {
				System.out.println("\thashing function "  + (i+1) + ": ");
				System.out.println("\t\t" + fillFactor[i]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Sorry File Not Found.");
		}
	}
	
	private static void addToCreatedWords(final Word the_word, final ArrayList<Word> words) {
		if (!words.contains(the_word)) {
			words.add(the_word);
		} else {
			for (Word w : words) {
				if (w.getWord().equals(the_word.getWord())) {
					w.increaseCount();
				}
			}
		}
	}
	
	private static File getInput(final String msg, final String fail_msg) {
		String input = JOptionPane.showInputDialog(msg);
		File file = null;
		boolean found = false;
		
		while (!found) {
			try {
				file = new File(input);
				found = true;
			} catch (NullPointerException e) {
				input = JOptionPane.showInputDialog(fail_msg);
			}
		}
		return file;
	}
	
	private static String removeSymbols(final String word) {
		String pattern = "^\\W+|\\W+$";
		return word.replaceAll(pattern,  "");
	}
	
	private static boolean isDigit(final String word) {
		try {
			Integer.parseInt(word);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static class CustomComparator implements Comparator<Word> {

		@Override
		public int compare(Word w1, Word w2) {
			int value = 0;
			if (w1.getCount() > w2.getCount()) {
				value = -1;
			} 
			if (w1.getCount() < w2.getCount()) {
				value = 1;
			}
			return value;
		}
		
	}
}
