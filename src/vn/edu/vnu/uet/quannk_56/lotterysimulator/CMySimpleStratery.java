package vn.edu.vnu.uet.quannk_56.lotterysimulator;

import java.util.Collections;
import java.util.Vector;

public class CMySimpleStratery implements IStratery {
	private static final int INITIAL_VALUE = 1;
	private static final double E = 2;
	static public int MAXIMUM_CAPITAL = 5000;
	private int capital = MAXIMUM_CAPITAL;
	private int lostStreak = 0;
	private int lastWinLottery;

	private Vector<Integer> lottery;

	@Override
	public int getCapital() {
		return capital;
	}

	private int currentValue;

	public int getValue() {
		return currentValue;
	}

	public CMySimpleStratery() {
		currentValue = INITIAL_VALUE;
		lottery = new Vector<Integer>();
		for (int i = 0; i < 100; i++)
			lottery.add(i);
	}

	private Vector<CLottery> lastBet = new Vector<CLottery>();

	private int j = 0;

	@Override
	public Vector<CLottery> BetForToday() {
		lastBet.clear();
		j = lastWinLottery - 33 / 2;
		if (j < 0)
			j = 0;
		if (j > 66)
			j = 66;
		Collections.shuffle(lottery);
		for (int i = 0; i < 34; i += 1) {
			lastBet.add(new CLottery((i + j), currentValue));
			capital -= currentValue;
		}
		return lastBet;
	}

	@Override
	public boolean TakeTheResult(int winLottery) {
		boolean isWin = false;
		lastWinLottery = winLottery;
		for (CLottery l : lastBet) {
			if (l.lottery == winLottery) {
				isWin = true;
				break;
			}
		}

		if (isWin) {
			capital += currentValue * ILotteryCompany.BET_RATIO;
			currentValue = INITIAL_VALUE;
			lostStreak = 0;
		} else {
			currentValue *= E;
			lostStreak++;
		}
		return isWin;
	}
}