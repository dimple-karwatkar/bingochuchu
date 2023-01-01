package com.bingogames.bingochuchu.Utils;

import java.util.Random;

public class Utilities {
	public static int[] getRandomBox() {
		Random r = new Random();
		int randomNumberOrigin = 1;
		int randomNumberBound = 26;
		int size = 25;
		int[] unique = r.ints(randomNumberOrigin, randomNumberBound)
		                .distinct()
		                .limit(size)
		                .toArray();
		return unique;
	}

}
