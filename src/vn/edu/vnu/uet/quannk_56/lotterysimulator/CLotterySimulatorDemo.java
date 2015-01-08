package vn.edu.vnu.uet.quannk_56.lotterysimulator;

import java.util.Vector;

public class CLotterySimulatorDemo {
	public static void main(String args[]) throws Exception {
		IStratery player = new CMySimpleStratery();
		ILotteryCompany lotteryCompany = new CMyRealLotteryCompany();

		Vector<CLottery> bet;
		int lastCapital;
		int deltaCapital;
		for (int iDay = 1; iDay <= lotteryCompany.GetCurrentDay(); iDay++) {
			lastCapital = player.getCapital();
			bet = player.BetForToday();
			if (player.getCapital() <= 0) {
				System.out.println("\t\tCapital is " + player.getCapital()
						+ "!!!. WE DIED\n");
				break;
			}
			int winLottery = lotteryCompany.GetWinLottery(iDay);
			boolean result = player.TakeTheResult(winLottery);
			if (iDay % 30 == 0)
				pressAnyKeyToContinue();
			System.out.print("Day " + iDay + ", win lottery = |" + winLottery
					+ "|");
			if (result)
				System.out.println("Win!!!");
			else
				System.out.println("Lost!!!");
			System.out.print("Capital: " + player.getCapital());

			deltaCapital = -lastCapital + player.getCapital();
			if (deltaCapital > 0)
				System.out.println("\t+" + deltaCapital);
			else
				System.out.println("\t" + deltaCapital);
			System.out.println();
		}
	}

	private static void pressAnyKeyToContinue() {
		System.out.println("Press any key to continue...");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}
}
