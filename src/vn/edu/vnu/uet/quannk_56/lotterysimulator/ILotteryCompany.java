package vn.edu.vnu.uet.quannk_56.lotterysimulator;

import java.util.Vector;

public interface ILotteryCompany {
	final static int MINIMUM_LOTTERY = 0;
	final static int MAXIMUM_LOTTERY = 99;
	final static int BET_RATIO = 70;	
	
	Vector<Integer> GetRecentWinLottery(int numberOfDays);
	
	/**
	 * 
	 * @param iDay >=0; iDay <= CurrentDay
	 * @return
	 */
	int GetWinLottery(int iDay) throws Exception;
	
	/**
	 * 
	 * @return the current day
	 */
	int GetCurrentDay();
}
