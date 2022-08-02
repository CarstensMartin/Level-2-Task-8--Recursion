package lcmRecursion;

public class LCMRecursion {

	public static int LCMChecker(int numberOne, int numberTwo, int commonResult) {

		// Add the biggest number to create multiples of the biggest number to test the
		// LCM
		commonResult += numberOne;

		// If the variable commonResult is Modulus by the smaller number(2nd) then
		// return the commonResult
		if (commonResult % numberTwo == 0) {
			return commonResult;
		}
		/*
		 * If not Modulus, use recursion and run the LCMChecker method again
		 * Use the commonResult answer and use it as a starting point for the multiples
		 */
		else {
			return LCMChecker(numberOne, numberTwo, commonResult);
		}
	}

	public static void main(String[] args) {
		// Declare the 2 numbers that we want to test the LCM
		int numberOne = 6;
		int numberTwo = 8;

		// Declare commonResult to keep track of every time the method runs with new
		// multiplication
		int commonResult = 0;

		// Please the biggest number on the left and the smaller number on the right
		if (numberOne > numberTwo) {
			System.out.println(LCMChecker(numberOne, numberTwo, commonResult) + " is the LCM.");
		} else {
			System.out.println(LCMChecker(numberTwo, numberOne, commonResult) + " is the LCM.");
		}

	}

}
