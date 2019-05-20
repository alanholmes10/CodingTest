import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ThreeFiveTest {
	
	ThreeFiveChecker threeFiveCheck = new ThreeFiveChecker();
	
	@Test
	public void testThreeFive() {
		
		String response = "";
		String threeFiveCorrect = "Threefive";
		String fiveCorrect = "Five";
		String threeCorrect = "Three";
		
		
		for(int i = 1; i<= 100; i++) {
			response = threeFiveCheck.threeFiveCheck(i);
			
			if(i%5 ==0 && i%3==0) {
				assertEquals(threeFiveCorrect, response);
			}else if(i%5 ==0) {
				assertEquals(fiveCorrect, response);
			}else if(i%3 ==0) {
				assertEquals(threeCorrect, response);
			}
				
				
				
			
		}
		
	}

}
