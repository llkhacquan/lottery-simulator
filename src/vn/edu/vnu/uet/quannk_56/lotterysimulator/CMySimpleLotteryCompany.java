package vn.edu.vnu.uet.quannk_56.lotterysimulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Vector;

public class CMySimpleLotteryCompany implements ILotteryCompany {
	private static int MAXIMUM_DATA = 4000;
	private int[] data;

	public CMySimpleLotteryCompany() {
		SecureRandom randomGenerator = new SecureRandom();
		data = new int[MAXIMUM_DATA];
		for (int i = 0; i < MAXIMUM_DATA; i++) {
			data[i] = Math.abs(randomGenerator.nextInt() % 100);
		}
	}

	@Override
	public Vector<Integer> GetRecentWinLottery(int numberOfDays) {
		Vector<Integer> result = new Vector<Integer>(numberOfDays);
		for (int i = 0; i < numberOfDays; i++) {
			result.add(data[GetCurrentDay() - 1 - numberOfDays + i]);
		}
		return result;
	}

	@Override
	public int GetWinLottery(int iDay) throws Exception {
		if (iDay < 0 || iDay > GetCurrentDay())
			throw new Exception("Invalid day");
		return data[iDay - 1];
	}

	@Override
	public int GetCurrentDay() {
		return MAXIMUM_DATA;
	}
}
