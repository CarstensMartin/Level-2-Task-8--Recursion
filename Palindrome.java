package palindromeRecursion;

import java.util.Arrays;

public class Palindrome {
	
	//Recursion Method to test if it is a Palindrome
	public static boolean PalindromeTest(String inputWord[], int start, int end) {
		//If there is no input text - return false
		if(inputWord == null) {
			return false;
		}
		// If there is only 1 letter - return true
		// If the letters was equal - (example 6) and will equally end with 0, then True (3 + 3) 
		if( inputWord.length <=1) {
			return true;
		}
		//If start exceeds or equal to end, return true it is a palindrome
		if(start >= end) {
			return true;
		}
		
		
		//If the first character & last character is not the same, False it is not a palinrome
		if(!(inputWord[start] == inputWord[end])) {
			return false;
		}
		//Else -run the recursion again with +1 start and -1 finish 
		else {
	
			return PalindromeTest(inputWord, (start +1), (end - 1));
		}	
	}


	public static void main(String[] args) {
		
		//Input word to array word  to test if it is a palindrome
		String[] inputWord = {"r","a","c","e","c","a","r"};
		
		//Run the palindome recursion to test if it is a palindrome(True) or not (False)
		boolean palindromeResult = PalindromeTest(inputWord, 0, (inputWord.length-1));
		
		//If True - display on console that it is a palindrome
		if(palindromeResult == true) {
			System.out.println(Arrays.toString(inputWord) + " is a palindrome.");
		}
		// Else if False, display it is not a palindrome
		else {
			System.out.println(Arrays.toString(inputWord) + " is NOT a palindrome.");
		}	
	}

}
