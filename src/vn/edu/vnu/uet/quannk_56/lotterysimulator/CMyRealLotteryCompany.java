package vn.edu.vnu.uet.quannk_56.lotterysimulator;

import java.util.Random;
import java.util.Vector;

public class CMyRealLotteryCompany implements ILotteryCompany {
	private int currentYear;
	private int currentMonth;
	private int currentDay;
	CDataOfYear[] data = new CDataOfYear[10];

	public CMyRealLotteryCompany() {
		for (int i = 2005; i <= 2014; i++) {
			data[i - 2005] = new CDataOfYear(i, "data/" + i + ".csv");
		}
		Random random = new Random();
		currentDay = Math.abs(random.nextInt() % 30);
		currentYear = Math.abs(random.nextInt() % 10);
		currentMonth = Math.abs(random.nextInt() % 12);

//		currentDay = 0;
//		currentYear = 9;
//		currentMonth = 0;

		System.out.println("Starting day is :" + (currentDay + 1) + "\\"
				+ (currentMonth + 1) + "\\" + (currentYear + 2005));
	}

	@Override
	public Vector<Integer> GetRecentWinLottery(int numberOfDays) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int GetWinLottery(int iDay) throws Exception {
		int result;
		do {
			result = data[currentYear].data[currentMonth][currentDay];
			currentDay++;
			if (currentDay == 31) {
				currentDay = 0;
				currentMonth++;
				if (currentMonth == 12) {
					currentMonth = 0;
					currentYear++;
					if (currentYear == 10) {
						currentYear = 0;
					}
				}
			}
		} while (result < 0);
		return result;
	}

	@Override
	public int GetCurrentDay() {
		return 10000;
	}

}
