
import org.junit.Test;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;

public class PostCodeTestingSuite {


	PostCodeChecker postCodeCheck = new PostCodeChecker();

	/*
	 * Test to ensure that postcodes in the format AA9A 9AA
	 * are correct including the restrictions on the first second and 4th positions
	 */
	@Test
	public void testFormatAA9A9AA() {
		String correctSevenDigit1 = "ec2a 4bx";
		String incorrectSevenDigitFirstPosition = "1c2a4bx";
		String incorrectSevenDigitSecondPosition = "ej2a4bx";
		String incorrectSevenDigitFourthPosition = "ec2z4bx";

		ArrayList<Character> correctSevenDigit1Array = new ArrayList<Character>();
		ArrayList<Character> incorrectSevenDigitArray1 = new ArrayList<Character>();
		ArrayList<Character> incorrectSevenDigitArray2 = new ArrayList<Character>();
		ArrayList<Character> incorrectSevenDigitArray3 = new ArrayList<Character>();


		correctSevenDigit1Array = postCodeCheck.RemoveSpace(correctSevenDigit1);
		incorrectSevenDigitArray1 = postCodeCheck.RemoveSpace(incorrectSevenDigitFirstPosition);
		incorrectSevenDigitArray2 = postCodeCheck.RemoveSpace(incorrectSevenDigitSecondPosition);
		incorrectSevenDigitArray3 = postCodeCheck.RemoveSpace(incorrectSevenDigitFourthPosition);


		assertEquals(true, postCodeCheck.checkPostCode(correctSevenDigit1Array));
		assertEquals(false, postCodeCheck.checkPostCode(incorrectSevenDigitArray1));
		assertEquals(false, postCodeCheck.checkPostCode(incorrectSevenDigitArray2));
		assertEquals(false, postCodeCheck.checkPostCode(incorrectSevenDigitArray3));


	}

	/*
	 * Testing the format AA99 9AA including the restriction around the single digit Areas
	 */

	@Test
	public void testFormatAA999AA() {
		String correctSevenDigit1 = "DG13 0LJ";
		String incorrectSevenDigitSingleDigit = "BR13 0LJ";
		String incorrectSevenDigitFifthPosition = "ec2apbx";
		String incorrectSevenDigitSecondPosition = "ez2c4bx";

		ArrayList<Character> correctSevenDigit1Array = new ArrayList<Character>();
		ArrayList<Character> incorrectSevenDigitArray1 = new ArrayList<Character>();
		ArrayList<Character> incorrectSevenDigitArray2 = new ArrayList<Character>();
		ArrayList<Character> incorrectSevenDigitArray3 = new ArrayList<Character>();


		correctSevenDigit1Array = postCodeCheck.RemoveSpace(correctSevenDigit1);
		incorrectSevenDigitArray1 = postCodeCheck.RemoveSpace(incorrectSevenDigitSingleDigit);
		incorrectSevenDigitArray2 = postCodeCheck.RemoveSpace(incorrectSevenDigitFifthPosition);
		incorrectSevenDigitArray3 = postCodeCheck.RemoveSpace(incorrectSevenDigitSecondPosition);


		assertEquals(true, postCodeCheck.checkPostCode(correctSevenDigit1Array));
		assertEquals(false, postCodeCheck.checkPostCode(incorrectSevenDigitArray1));
		assertEquals(false, postCodeCheck.checkPostCode(incorrectSevenDigitArray2));
		assertEquals(false, postCodeCheck.checkPostCode(incorrectSevenDigitArray3));


	}

	/*
	 * Testing the format A9A 9AA including the restriction around the thrid and last position
	 */

	@Test
	public void testFormatA9A9AA() {
		String correctSixDigit1 = "B2D 7UJ";
		String incorrectSixDigitThirdPosition = "B2y 7UJ ";
		String incorrectSixDigitLastPosition = "B2D 7UC";


		ArrayList<Character> correctSixDigit1Array = new ArrayList<Character>();
		ArrayList<Character> incorrectSixDigitArray1 = new ArrayList<Character>();
		ArrayList<Character> incorrectSixDigitArray2 = new ArrayList<Character>();



		correctSixDigit1Array = postCodeCheck.RemoveSpace(correctSixDigit1);
		incorrectSixDigitArray1 = postCodeCheck.RemoveSpace(incorrectSixDigitThirdPosition);
		incorrectSixDigitArray2 = postCodeCheck.RemoveSpace(incorrectSixDigitLastPosition);



		assertEquals(true, postCodeCheck.checkPostCode(correctSixDigit1Array));
		assertEquals(false, postCodeCheck.checkPostCode(incorrectSixDigitArray1));
		assertEquals(false, postCodeCheck.checkPostCode(incorrectSixDigitArray2));



	}

	/*
	 * Testing the format AA9 9AA including the restriction around the zero in the third position 
	 * and areas with a double digit district
	 */


	@Test
	public void testFormatAA99AA() {
		String correctSixDigit1 = "DG7 1LN";
		String correctSixDigit2 = "BL0 1ln";
		String incorrectSixDigitDoubleDigitOnly = "AB7 1ln";
		String incorrectSixDigitFalseZero = "AB0 1ln";


		ArrayList<Character> correctSixDigit1Array = new ArrayList<Character>();
		ArrayList<Character> correctSixDigit2Array = new ArrayList<Character>();
		ArrayList<Character> incorrectSixDigitArray1 = new ArrayList<Character>();
		ArrayList<Character> incorrectSixDigitArray2 = new ArrayList<Character>();



		correctSixDigit1Array = postCodeCheck.RemoveSpace(correctSixDigit1);
		correctSixDigit2Array = postCodeCheck.RemoveSpace(correctSixDigit2);
		incorrectSixDigitArray1 = postCodeCheck.RemoveSpace(incorrectSixDigitDoubleDigitOnly);
		incorrectSixDigitArray2 = postCodeCheck.RemoveSpace(incorrectSixDigitFalseZero);



		assertEquals(true, postCodeCheck.checkPostCode(correctSixDigit1Array));
		assertEquals(true, postCodeCheck.checkPostCode(correctSixDigit2Array));
		assertEquals(false, postCodeCheck.checkPostCode(incorrectSixDigitArray1));
		assertEquals(false, postCodeCheck.checkPostCode(incorrectSixDigitArray2));



	}

	@Test
	public void testFormatA999AA() {

		String correctSixDigit1 = "M27 6NF";
		String incorrectSixDigitThirdLastPosition = "M27 rUJ";
		String incorrectSixDigitFirstPosition = "Q27 6NF";


		ArrayList<Character> correctSixDigit1Array = new ArrayList<Character>();
		ArrayList<Character> incorrectSixDigitArray1 = new ArrayList<Character>();
		ArrayList<Character> incorrectSixDigitArray2 = new ArrayList<Character>();



		correctSixDigit1Array = postCodeCheck.RemoveSpace(correctSixDigit1);
		incorrectSixDigitArray1 = postCodeCheck.RemoveSpace(incorrectSixDigitThirdLastPosition);
		incorrectSixDigitArray2 = postCodeCheck.RemoveSpace(incorrectSixDigitFirstPosition);



		assertEquals(true, postCodeCheck.checkPostCode(correctSixDigit1Array));
		assertEquals(false, postCodeCheck.checkPostCode(incorrectSixDigitArray1));
		assertEquals(false, postCodeCheck.checkPostCode(incorrectSixDigitArray2));



	}

	/*
	 * Testing the format A9 9AA including the restriction around the second position 
	 * and the last digit
	 */

	@Test
	public void testFormatA99AA() {

		String correctFiveDigit1 = "S1 2PP";
		String incorrectFiveDigitSecondPosition = "Bs 1pt";
		String incorrectFiveDigitSecondLastPosition = "S1 2kP";


		ArrayList<Character> correctFiveDigit1Array = new ArrayList<Character>();
		ArrayList<Character> incorrectFiveDigitArray1 = new ArrayList<Character>();
		ArrayList<Character> incorrectFiveDigitArray2 = new ArrayList<Character>();



		correctFiveDigit1Array = postCodeCheck.RemoveSpace(correctFiveDigit1);
		incorrectFiveDigitArray1 = postCodeCheck.RemoveSpace(incorrectFiveDigitSecondPosition);
		incorrectFiveDigitArray2 = postCodeCheck.RemoveSpace(incorrectFiveDigitSecondLastPosition);



		assertEquals(true, postCodeCheck.checkPostCode(correctFiveDigit1Array));
		assertEquals(false, postCodeCheck.checkPostCode(incorrectFiveDigitArray1));
		assertEquals(false, postCodeCheck.checkPostCode(incorrectFiveDigitArray2));



	}


	/*
	 * Testing the format print out of all the post codes to ensure the print out is the correct
	 */

	@Test
	public void testFormatFinalThree() {

		String sevenDigit = "EC2A4b x";
		String sixDigit1 = "BL03ER";
		String sixDigit2 = "M 225XB";
		String fiveDigit = "W39 PT";

		String sevenDigitCorrect = "EC2A 4BX";
		String sixDigit1Correct = "BL0 3ER";
		String sixDigit2Correct = "M22 5XB";
		String fiveDigitCorrect = "W3 9PT";


		ArrayList<Character> correctSevenDigit = new ArrayList<Character>();
		ArrayList<Character> correctSixDigit = new ArrayList<Character>();
		ArrayList<Character> correctSixDigit2 = new ArrayList<Character>();
		ArrayList<Character> correctFiveDigit = new ArrayList<Character>();



		correctSevenDigit = postCodeCheck.RemoveSpace(sevenDigit);
		correctSixDigit = postCodeCheck.RemoveSpace(sixDigit1);
		correctSixDigit2 = postCodeCheck.RemoveSpace(sixDigit2);
		correctFiveDigit = postCodeCheck.RemoveSpace(fiveDigit);

		postCodeCheck.checkPostCode(correctSevenDigit);
		postCodeCheck.checkPostCode(correctSixDigit);
		postCodeCheck.checkPostCode(correctSixDigit2);
		postCodeCheck.checkPostCode(correctFiveDigit);




		assertEquals(sevenDigitCorrect, postCodeCheck.correctFormat(correctSevenDigit));
		assertEquals(sixDigit1Correct, postCodeCheck.correctFormat(correctSixDigit));
		assertEquals(sixDigit2Correct, postCodeCheck.correctFormat(correctSixDigit2));
		assertEquals(fiveDigitCorrect, postCodeCheck.correctFormat(correctFiveDigit));



	}
}