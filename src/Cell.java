import java.util.LinkedList;


public class Cell {
	private LinkedList<Word> words;
	
	public Cell(final Word the_word) {
		words = new LinkedList<Word>();
		words.add(the_word);
		
	}
	
	public void addWord(final Word the_word) {
		// if cell doesn't contain word, add the word
		if (!words.contains(the_word)) {
			// TODO add word alphabetically..
			words.add(the_word); 
		} else {
			// otherwise, increase that word's count
			for (Word w : words) {
				if (w.getWord().equals(the_word.getWord())) {
					w.increaseCount();
				}
			}
		}
	}
}
