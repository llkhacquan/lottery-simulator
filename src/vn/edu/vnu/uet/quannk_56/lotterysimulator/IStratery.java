package vn.edu.vnu.uet.quannk_56.lotterysimulator;

import java.util.Vector;

public interface IStratery {
	Vector<CLottery> BetForToday();

	boolean TakeTheResult(int winLottery);

	int getCapital();
}
