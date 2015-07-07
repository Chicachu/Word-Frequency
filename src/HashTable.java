public class HashTable {
	private Cell[] my_table;
	private int TABLE_SIZE = 9973;
	private int[] polyIndex;
	private int cells_used = 0;
	
	public HashTable() {
		my_table = new Cell[TABLE_SIZE];
		initializePolynomialIndex();
	}
	
	/**
	 * Uses hashing function 1.
	 * @param the_word The word to be added.
	 * @param hashNum Hash function to use (1-5).
	 */
	public void addWord1(final String the_word) {
		Cell list;
		int index = hash1(the_word);
		Word word = new Word(the_word);
		// create a new cell of words if array at index is null
		if (my_table[index] == null) {
			list = new Cell(word);
			my_table[index] = list;
			cells_used++;
		} else {
			// otherwise, add to cell
			list = my_table[index];
			list.addWord(word);
			my_table[index] = list;
		}
	}
	
	public void addWord2(final String the_word) {
		Cell list;
		int index = hash2(the_word);
		Word word = new Word(the_word);
		// create a new cell of words if array at index is null
		if (my_table[index] == null) {
			list = new Cell(word);
			my_table[index] = list;
			cells_used++;
		} else {
			// otherwise, add to cell
			list = my_table[index];
			list.addWord(word);
			my_table[index] = list;
		}
	}
	
	public void addWord3(final String the_word) {
		Cell list;
		int index = hash3(the_word);
		Word word = new Word(the_word);
		// create a new cell of words if array at index is null
		if (my_table[index] == null) {
			list = new Cell(word);
			my_table[index] = list;
			cells_used++;
		} else {
			// otherwise, add to cell
			list = my_table[index];
			list.addWord(word);
			my_table[index] = list;
		}
	}
	
	public void addWord4(final String the_word) {
		Cell list;
		int index = hash4(the_word);
		Word word = new Word(the_word);
		// create a new cell of words if array at index is null
		if (my_table[index] == null) {
			list = new Cell(word);
			my_table[index] = list;
			cells_used++;
		} else {
			// otherwise, add to cell
			list = my_table[index];
			list.addWord(word);
			my_table[index] = list;
		}
	}
	
	public void addWord5(final String the_word) {
		Cell list;
		int index = hash5(the_word);
		Word word = new Word(the_word);
		// create a new cell of words if array at index is null
		if (my_table[index] == null) {
			list = new Cell(word);
			my_table[index] = list;
			cells_used++;
		} else {
			// otherwise, add to cell
			list = my_table[index];
			list.addWord(word);
			my_table[index] = list;
		}
	}
	
	public int getCellCount() {
		return cells_used;
	}
	
	public int getTableSize() {
		return TABLE_SIZE;
	}
	
	/**
	 * 5 hashing functions in a switch statement, choose one by enter 1-5 as second param.
	 * @param key The key.
	 * @param hashNumber The hashing function to use (1-5).
	 * @return The hashcode.
	 */
	public int hash1(final String key) {
		int indexOfKey = 1;
			double hashInd = 0.0, sum = 0.0;
			
			for (int j = 0; j < key.length(); j++) {
				sum += (int)key.charAt(j);
				hashInd += (double)((int)key.charAt(j)) * polyIndex[j];
			}
			indexOfKey = ((int) ((int)hashInd % sum) * key.length()) % TABLE_SIZE;
			return indexOfKey;
	}

	public int hash2(final String key) {
		int index = 1;
		int sum = key.hashCode();
		if (sum <  0) {
			sum = 0 - sum;
		}
		for (int i = 0; i < 5; i++) {
			sum += sum;
			index += sum * polyIndex[i] + sum;
		}
		if (index < 0) {
			index = 0 - index;
		}
		return index % TABLE_SIZE;
	}
	
	public int hash3(final String key) {
		int index2 = key.hashCode() * key.hashCode(); 
		for (int i = 0; i < key.length(); i++) {
			index2 *= polyIndex[i];
		}
		if (index2 < 0) {
			index2 = 0 - index2;
		}
		return index2 % TABLE_SIZE;
	}
	
	public int hash4(final String key) {
		int ind = key.hashCode() * key.hashCode(); 
		for (int i = 0; i < key.length(); i++) {
			// subtle difference between this one and the one above.
			ind += polyIndex[i];
		}
		if (ind < 0) {
			ind = 0 - ind;
		}
		return ind % TABLE_SIZE;
	}
	public int hash5(final String key) {
		int keyCode =  key.hashCode();
		keyCode *= keyCode + keyCode;
		if (keyCode < 0) {
			keyCode = 0 - keyCode;
		}
		return keyCode % TABLE_SIZE;
	}
	private void initializePolynomialIndex() {
		polyIndex = new int[40];
		for (int i = 0; i < 40; i++) {
			polyIndex[i] = (int)Math.pow(11, i);
		}
	}
}
