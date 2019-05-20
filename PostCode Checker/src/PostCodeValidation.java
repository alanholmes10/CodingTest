import java.util.ArrayList;

public class PostCodeValidation {

	public static void main(String[] args) {

		PostCodeChecker postCodeChecker = new PostCodeChecker();

		ArrayList<Character> validatedPostCode = new ArrayList<Character>();
		String[] validPostcodes = new String[] {"BL0 3ER", "OL8 2RF","IP33 1HG","BH11 8TP","DY8 3LB","BD14 6HX","OX28 1EE","M22 5XB","TS25 5HE","EH23 4PP","BB2 9LF","RH13 8BU","CF11 7EE",
				"BR12 8LE","G22 7RG","NP20 6HA","DG13 0LJ","CB1 2QR","BT36 6LB","LA7 7JY","KY11 1BH","SG9 9SF","BT16 2EY","S17 9DX","SW2 3TS","DT9 4RX","BS27 3LR","BT6 0JE","S41 9LQ","EC1V 9FL",
				"CM14 4UG","WR13 5AZ","SN12 8QL","NW1 8NH","BS14 0JF","BB10 3PJ","W14 0NE","PO3 5BU","CW12 4HB","BN1 3JE","OL10 2QP","ME17 1QR","PR4 1UQ","IG7 4PL","BD22 7JR","WD7 7EX","M34 6JY","OX7 7HB","HA4 7SE",
				"CT9 3HB","NP13 3LP","BB18 5EP","CA7 1HW","TR11 5DZ","L8 0YA","ab5 0HE","IM1 3JY","EH14 7HA","CH4 9NL","N17 8HG","EX15 1FG","WV13 1SJ","WA2 7DT","AL1 1XU","WA4 6JQ","FY5 2TT","PE14 8RB","NN3 9NX",
				"LN4 3PA","CM22 7SH","TD15 9BS","SM5 1AP","DA13 0QL","M44 5UB","AB21 9DH","NE31 2XQ","ME1 2RW","CF11 7BP","SW17 6BB","EX23 8GD","SN5 7YE","LS26 8BT","S6 3DQ",
				"BD19 4TD","NW11 0AE","B23 7UJ","S1 2PP","DE21 4LN","M27 6NF","TS29 6JS","W3 9PT","DG7 1LN","TF2 7JB","ME2 3HF","DE7 4EL","RM19 1TR","LS13 4RA","DT2 0AR",
				"SN5 5QS","LS27 8EB"};



		for(String a: validPostcodes) {

			validatedPostCode = postCodeChecker.RemoveSpace(a);

			if(postCodeChecker.checkPostCode(validatedPostCode)) {
				System.out.println("Valid " + postCodeChecker.correctFormat(validatedPostCode));


			}else {
				System.out.println("Invalid " + postCodeChecker.correctFormat(validatedPostCode));

			}
		}

	}


}
