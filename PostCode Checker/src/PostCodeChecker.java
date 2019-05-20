import java.util.ArrayList;

public class PostCodeChecker {



	/*
	 * Method to remove any spaces from the postcode and
	 * create an array list of the individual elements of the string
	 */

	public ArrayList<Character> RemoveSpace(String Postcode) {

		String postCode = Postcode;
		ArrayList<Character> postCodeNoSpace = new ArrayList<Character>();
		int arrayPlace=0;

		//convert string to upper so easier to check ascii


		String postCodeUpper = postCode.toUpperCase();




		for(int i=0;i<postCodeUpper.length();i++) {
			if(postCodeUpper.charAt(i) != ' ') {
				postCodeNoSpace.add(arrayPlace, postCodeUpper.charAt(i));
				arrayPlace+=1;
			}
		}


		return postCodeNoSpace;


	}
	/*
	 * This is the final method bringing together all the necessary methods
	 * and give a true or false value depending on the outcome of the outcome of the 
	 * subsequent methods
	 */

	public boolean checkPostCode(ArrayList<Character> listOfPostcodeElements) {

		boolean isValid = false;

		if(postCodeAreaCheck(listOfPostcodeElements) && finaThreeCheck(listOfPostcodeElements)) {
			isValid = true;
		}

		return isValid;

	}

	/*
	 * This class is to check the fist part of the post code
	 * It checks the length of the postcode and from there will
	 * run through the different parameters to make a valid postcode
	 * It will first check the first element to ensure it is a letter and is
	 * one of the element acceptable for the first place
	 * 
	 * Then depending on the length of the post code it will call a method to check the format 
	 * of that post type of postcode
	 */

	private boolean postCodeAreaCheck(ArrayList<Character> listOfPostcodeElements) {
		boolean isCorrect = true;


		if(Character.isDigit(listOfPostcodeElements.get(0)) || validateFirstPosition(listOfPostcodeElements.get(0))) {
			isCorrect = false;
		}



		if(listOfPostcodeElements.size() == 7 && isCorrect == true) {


			isCorrect = validateSevenDigitPostCode(listOfPostcodeElements);

		}else if(listOfPostcodeElements.size() == 6 && isCorrect == true) {

			isCorrect = validateSixDigitPostCode(listOfPostcodeElements);

		}else if(listOfPostcodeElements.size() == 5 && isCorrect == true) {

			isCorrect = validateFiveDigitPostcode(listOfPostcodeElements);

		}



		return isCorrect;

	}

	/*
	 * This is to check the final 3 elements
	 * The code will first check that the first element is a digit and
	 * then will check that the next two are characters that are acceptable for
	 * the positions
	 */
	private boolean finaThreeCheck(ArrayList<Character> listOfPostcodeElements) {
		boolean isValid = false;

		//System.out.println(list.get(list.size()-3));

		if(Character.isDigit(listOfPostcodeElements.get(listOfPostcodeElements.size()-3))) {


			if(validateLastTwo(listOfPostcodeElements)) {

				isValid = true;
			}


		}
		return isValid;

	}

	/*
	 * This will validate the postcode by checking the 2 different variations in the postcode area
	 *  of a seven digit post code as the fist digit is already checked we only need to check the 
	 *  second digit is within the parameters We do this by checking the ASCII value . 
	 *  The Third element is a digit in all cases 
	 *  
	 *  In the first case the 4th is a digit as the fomat is AA99 9AA and We also check to make sure it is not a Area Code with single digit district.
	 *  
	 *  In the second case i validate the forth against the acceptable characters for the fourth char in the format AA9A 9AA 
	 */



	private boolean validateSevenDigitPostCode(ArrayList<Character> listOfPostcodeElements) {
		boolean isCorrect;
		//getting ascii of second digit of postcode

		int secondDigit = listOfPostcodeElements.get(1);

		//System.out.println(secondDigit);


		//
		if(((secondDigit < 73 && secondDigit > 64) || (secondDigit > 74 && secondDigit < 90)) 
				&& Character.isDigit(listOfPostcodeElements.get(2)) && Character.isDigit(listOfPostcodeElements.get(3)) 
				&& !isSingleDigitPostCodeOnly(listOfPostcodeElements)){

			//System.out.println("in here");

			isCorrect = true;

		}else if(((secondDigit < 73 && secondDigit > 64) || (secondDigit > 74 && secondDigit < 90)) 
				&& Character.isDigit(listOfPostcodeElements.get(2)) && validateFourthPosition(listOfPostcodeElements.get(3))){

			isCorrect = true;

		}else {

			isCorrect = false;

		}

		return isCorrect;

	}



	/*
	 * There is three different cases on 6 element postcodes
	 * 1 is the second element is a digit and the third is a from a set of letters the format is A9A 9AA
	 * 
	 * 2 is the second element is a letter and the other is a digit as the format is AA9 9AA we must ensure 
	 * that the first two letters are not the 3 that are double only (AA99 9AA)
	 * 
	 * 3 both are digits we need to ensure that these are both digits 
	 */


	private boolean validateSixDigitPostCode(ArrayList<Character> listOfPostcodeElements) {
		boolean isCorrect;

		boolean isOnlyDouble = false;


		isOnlyDouble = isDoubleDigitPostCodeOnly(listOfPostcodeElements);
		//System.out.println(secondDigit);

		if(Character.isDigit(listOfPostcodeElements.get(1)) && validateThirdPosition(listOfPostcodeElements.get(2))) {

			//System.out.println("case 1");

			isCorrect = true;

		}else if( (Character.isLetter(listOfPostcodeElements.get(1)))&& (Character.isDigit(listOfPostcodeElements.get(2))) && !isOnlyDouble) {

			//System.out.println("case 2");
			if(listOfPostcodeElements.get(2) == 0 && !isZeroDistrictPostCode(listOfPostcodeElements)) {

				isCorrect = false;

			}else {
				isCorrect = true;
			}

		}else if( (Character.isDigit(listOfPostcodeElements.get(1)))&& (Character.isDigit(listOfPostcodeElements.get(2)))) {

			//System.out.println("case 3");

			isCorrect = true;

		}else {

			isCorrect = false;

		}
		return isCorrect;

	}

	/*
	 * the first part of the 5 digit postcode is 
	 * a letter(already checked ) and a number
	 */

	private boolean validateFiveDigitPostcode(ArrayList<Character> listOfPostcodeElements) {
		boolean isCorrect;
		if(Character.isDigit(listOfPostcodeElements.get(1))) {

			isCorrect = true;

		}else {

			isCorrect = false;

		}
		return isCorrect;

	}

	/*
	 * The following 4 methods are used to validate individual 
	 * positions in the postcodes
	 */


	/*
	 * Validate the fourth postiion in the format AA9A 9AA
	 */


	private boolean validateFourthPosition(char letter) {

		boolean valid = false;

		char[] fourthPositionLetters = {'A','B','E','H','M','N','P','R','V','W','X','Y'};

		for(char a: fourthPositionLetters) {

			if(a == letter) {

				valid = true;

			}
		}

		return valid;

	}

	/*
	 * Validate the third postiion in the format A9A 9AA
	 */


	private boolean validateThirdPosition(char letter) {

		boolean valid = false;

		char[] thirdPositionLetters = {'A','B','C','D','E','F','G','H','J','K','P','S','T','U','W'};

		for(char a: thirdPositionLetters) {

			if(a == letter) {

				valid = true;

			}
		}

		return valid;

	}


	/*
	 * Validate the first postiion in all cases
	 */



	private boolean validateFirstPosition(char letter) {

		boolean invalid = false;

		char[] firstPositionLetters = {'V','Q','X'};

		for(char a: firstPositionLetters) {

			if(a == letter) {

				invalid = true;

			}
		}

		return invalid;

	}




	/*
	 * This Validates the last 2 digits of the postcode ensuring it is in the correct format
	 */


	private boolean validateLastTwo(ArrayList<Character> listOfPostcodeElements) {

		boolean valid = false;
		boolean lastChar = false;
		boolean secondLastChar = false;

		char[] lastTwoPositionLetters = {'A','B','D','E','F','G','H','J','L','N','P','Q','R','S','T','U','W','X','Y','Z'};

		for(char a: lastTwoPositionLetters) {

			if(a == listOfPostcodeElements.get(listOfPostcodeElements.size()-2)) {

				secondLastChar = true;

			}
		}

		for(char b: lastTwoPositionLetters) {

			if(b == listOfPostcodeElements.get(listOfPostcodeElements.size()-1) ) {

				lastChar = true;

			}
		}

		if(lastChar && secondLastChar) {
			valid = true;
		}

		return valid;
	}

	/*
	 * This is a method to format the postcode correctly by adding a space and adding
	 * the chars to a string to make a readable postcode
	 */

	public String correctFormat(ArrayList<Character> listOfPostcodeElements) {

		ArrayList<Character> postCodeFormatted = new ArrayList<Character>();
		String formattedPostCode = "";

		postCodeFormatted.addAll(listOfPostcodeElements);

		if(postCodeFormatted.size() == 7) {

			postCodeFormatted.add(4,' ');

			for(char a: postCodeFormatted) {

				formattedPostCode += a;

			}

		}else if(postCodeFormatted.size() == 6) {

			postCodeFormatted.add(3,' ');

			for(char a: postCodeFormatted) {

				formattedPostCode += a;

			}

		}else if(postCodeFormatted.size() == 5) {

			postCodeFormatted.add(2,' ');

			for(char a: postCodeFormatted) {

				formattedPostCode += a;

			}

		}

		return formattedPostCode;


	}


	/*
	 * The String Array is 3 cases where the the areacode chars are double digits
	 */



	private boolean isDoubleDigitPostCodeOnly(ArrayList<Character> listOfPostcodeElements) {
		String[] onlyDoubleDigit = {"AB", "LL", "SO"};

		Boolean isOnlyDouble = false;

		String firstTwoLetters = listOfPostcodeElements.get(0).toString() + listOfPostcodeElements.get(1).toString() ;

		for(String a: onlyDoubleDigit) {
			if(a.equalsIgnoreCase(firstTwoLetters)) {
				isOnlyDouble = true;
			}
		}



		return isOnlyDouble;
	}

	/*
	 * The elements in the array are the area code is two letters when the next element is a single digit
	 */

	private boolean isSingleDigitPostCodeOnly(ArrayList<Character> listOfPostcodeElements) {
		String[] onlySingleDigit = {"BR", "FY", "HA", "HD", "HG", "HR", "HS", "HX", "JE", "LD", "SM", "SR", "WC", "WN", "ZE"};

		Boolean isOnlySingle = false;

		String firstTwoLetters = listOfPostcodeElements.get(0).toString() + listOfPostcodeElements.get(1).toString() ;



		for(String a: onlySingleDigit) {
			if(a.equalsIgnoreCase(firstTwoLetters)) {
				isOnlySingle = true;
			}
		}



		return isOnlySingle;
	}

	/*
	 * Validates the zero district postcodes
	 */



	private boolean isZeroDistrictPostCode(ArrayList<Character> listOfPostcodeElements) {
		String[] onlyZeroDistrict = {"BL", "BS", "CM", "CR", "FY", "HA", "PR", "SL", "SS"};

		Boolean onlyZero = false;

		String firstTwoLetters = listOfPostcodeElements.get(0).toString() + listOfPostcodeElements.get(1).toString() ;

		System.out.println("enter");

		for(String a: onlyZeroDistrict) {
			if(a.equalsIgnoreCase(firstTwoLetters)) {
				onlyZero = true;
			}
		}



		return onlyZero;
	}
}


