import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ThreeFiveChecker {

	public String threeFiveCheck(int i){


		String response = "";


		if(i%5 ==0 && i%3==0) {
			response = "Threefive";
		}else if(i%5 ==0) {
			response = "Five";
		}else if(i%3 ==0) {
			response = "Three";
		}else
			response = Integer.toString(i);


		return response;
	}

}
