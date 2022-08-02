package searchReplace;

//Import required packages
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ReplaceSearch {

	// Recursion method to search and replace
	public static ArrayList<String> SearchReplace(ArrayList<String> originalTextArray, int charStart,
			ArrayList<String> findTextArray, ArrayList<String> replaceTextArray) {

		// Base statement - End recursion once last letter in original text is tested
		if (charStart == originalTextArray.size() - 1) {

			return originalTextArray;
		}

		// Code to check if the it matches the search result
		// Start with True statement
		boolean matchSearch = true;

		// Use to run the for loop and not influence the charStart
		int charStartPosition = charStart;

		// For loop to test if it matches the text
		for (int x = 0; x < findTextArray.size(); x++) {

			// If already failed a previous letter, remain false
			if (matchSearch == false) {
				matchSearch = false;
			}
			// Else test if this letter matches the find letter
			else if ((originalTextArray.get(charStartPosition)).equals((findTextArray.get(x)))) {
				matchSearch = true;
			} // Else if it fails above test, give a false result
			else {
				matchSearch = false;
			}
			// Add 1 position for the Original text position to test next letter
			charStartPosition++;
		}

		// If the match is True - build the new array (original Word)
		if (matchSearch == true) {

			// Create new List array
			ArrayList<String> newOriginalTextArray = new ArrayList<>();

			// Create an array of the sentence
			// Capture letters before the first start letters with
			for (int x = 0; x < charStart; x++) {
				newOriginalTextArray.add(originalTextArray.get(x));
			}

			// Replace the find letters with the new words
			for (int x = 0; x < replaceTextArray.size(); x++) {
				newOriginalTextArray.add(replaceTextArray.get(x));
			}

			// Capture letters after the start new replacement word
			for (int x = 0; x < (originalTextArray.size() - (charStart + findTextArray.size())); x++) {
				newOriginalTextArray.add(originalTextArray.get(x + (charStart + findTextArray.size())));
			}

			// Replace original array with new array
			originalTextArray = newOriginalTextArray;
		}

		// Run recursion until the base case - last letter is reached
		return SearchReplace(originalTextArray, charStart + 1, findTextArray, replaceTextArray);

	}

	public static void main(String[] args) {

		// Ask user for input with Prompt box
		String originalText = JOptionPane.showInputDialog("Please enter a string:");

		// Create an array of the sentence
		ArrayList<String> originalTextArray = new ArrayList<>();
		for (int x = 0; x < originalText.length(); x++) {
			originalTextArray.add(x, Character.toString(originalText.charAt(x)));
		}

		// Ask user for input with Prompt box
		String findText = JOptionPane.showInputDialog("Please enter the substring you wish to find:");

		// Create an array of the search item
		ArrayList<String> findTextArray = new ArrayList<>();
		for (int x = 0; x < findText.length(); x++) {
			findTextArray.add(x, Character.toString(findText.charAt(x)));
		}

		// Ask user for input with Prompt box
		String replaceText = JOptionPane.showInputDialog("Please enter a string to replace the given substring:");

		// Create an array of the replace item
		ArrayList<String> replaceTextArray = new ArrayList<>();

		for (int x = 0; x < replaceText.length(); x++) {
			replaceTextArray.add(x, Character.toString(replaceText.charAt(x)));
		}

		// Start at position 0 the characters
		int charStart = 0;

		// Run the recursion formula
		ArrayList<String> result = SearchReplace(originalTextArray, charStart, findTextArray, replaceTextArray);

		// Convert Array list to String
		String resultString = "";
		for (int x = 0; x < result.size(); x++) {
			resultString += result.get(x);
		}

		// Display Alert with new word after search and replace was done
		JOptionPane.showMessageDialog(new JFrame(), resultString, "Dialog", JOptionPane.ERROR_MESSAGE);

		// Display on console
		System.out.println("\nOriginal Text: " + originalText);
		System.out.println("\nFind Text: " + findText);
		System.out.println("\nReplace Text: " + replaceText);
		System.out.println("\nReplace Text result: " + resultString);

		// ALTERNATIVE OPTION IF RECURSION IS NOT USED:
		// IN JAVA THE SEARCH AND REPLACE FUNCTION IS PRE BUILT:
		// String newWord = originalText.replaceAll(findText, replaceText);
		// System.out.println(newWord);

	}

}
