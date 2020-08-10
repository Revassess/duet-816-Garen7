package com.revature.tier1;

public class NumberSumLength {

	public static boolean checkNumberPowerLength(long num) {
		long sum = 0;
		long tmpNum = num;
		//casting to int floors the decimal
		final int len = 1 + (int)Math.log10(tmpNum);
		while (tmpNum > 0) {
			sum += Math.pow(tmpNum%10, len);
			tmpNum /= 10;
		}

		return sum == num;
	}
}
