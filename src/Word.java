
public class Word {
	private String word; 
	private int count;
	
	public Word(final String the_word) {
		word = the_word; 
		count = 1;
	}
	
	public void increaseCount() {
		count++;
	}
	
	public String getWord() {
		return word;
	}
	
	public int getCount() {
		return count;
	}
	
	@Override
	public boolean equals(Object other) {
		boolean equals = false;
		if (other instanceof Word) {
			Word other_word = (Word)other;
			equals = this.getWord().equals(other_word.getWord());
		}
		
		return equals;
	}
}
