package commonutils;

import java.util.Random;

public class JavaUtils {

	public int getRandomNumber() {
		Random r = new Random();
		int rndm = r.nextInt(100);

		return rndm;
	}

}
