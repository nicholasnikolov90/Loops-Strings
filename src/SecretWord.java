
/**
 * @author Nick Nikolov
 *
 *Class Name: SecretWord
 *
 *This class defines a secret word and displays only the characters that have been guessed by the user
 *the remaining characters of the secret word are kept hidden until guessed correctly
 */

public class SecretWord {
	
	private String secretWord; //user attempts to guess this word
	private String displayedWord; //display current progress the user has towards correct guess of the word
	private char displayChar; //used to mask characters in the secret word
	
	
	/**
	 * Used to initialize the secret word, the character used to mask the secret word, and the displayedWord (masked by the character)
	 */
	public SecretWord() {
		this.secretWord = "switzerland";
		this.displayChar = '*';
		this.displayedWord = replaceChars(secretWord, displayChar);
	}
	
	/** 
	 * @return secretWord (String) way to bypass the guessing game and display the secret word
	 */
	public String getSecretWord() {
		return this.secretWord;
	}
	
	/** Replaces all letters in the s1 string by a masking character ch
	 * This is only called once to initialize the program
	 * @param s1 (String) - The input string to be masked
	 * @param ch (char) - character used to mask the s1 string and display to the GUI
	 * @return the s1 string (String) masked by the masking character, the entire secret word is hidden
	 */
	public String replaceChars(String s1, char ch) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < s1.length(); i++)
		{
			builder.append(ch);
		}
		return builder.toString();
		}
	

	/**returns the displayedWord with the current progress the user has made towards guessing the secret word
	 * 
	 * @param secretWord (String) the goal of the same is to guess this word
	 * @param displayedWord (String) current progress the user has made toward guessing the secret word
	 * @param ch (char) current guess input by the user
	 * @return displayedWord (String) the current progress the user has made including the most current guess
	 * 
	 * unhides the letters in the displayed word if they are guessed correctly
	 */
	public String replaceChars(String s1, String s2, char ch) {
		StringBuilder dw = new StringBuilder(s2);
		for (int i = 0; i < s1.length(); i++) {
			if (ch == s1.charAt(i)) {
				dw.setCharAt(i, ch);
			}
		}
		return dw.toString();
	}
	
	
	/**
	 * @return displayed word (String) with current game progress
	 */
	public String getDisplayedWord() {
		return this.displayedWord;
	}
		
	/** Used to check if the current guess of the user is correct 
	 * 
	 * @param a (char) - the users current character guess
	 * @return true if the guessed character is in the secret word, otherwise false
	 */
	public boolean makeGuess(char ch) {
		boolean guessCondition = false;
		for (int i  = 0; i < this.secretWord.length(); i++) {
			
			if (ch == this.secretWord.charAt(i)) { //only pass if statement if user guesses correct character
				//updates the displayed word with the current character guess
				this.displayedWord = replaceChars(this.secretWord, this.displayedWord, ch);
				guessCondition = true;
			}
		}
		return guessCondition;
	}
		
	}
	
	
	
