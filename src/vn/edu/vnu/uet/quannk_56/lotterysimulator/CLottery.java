package vn.edu.vnu.uet.quannk_56.lotterysimulator;

public class CLottery {
	public final int lottery;
	public final int value;

	public CLottery(int _lottery, int _value) {
		lottery = _lottery;
		value = _value;
		
		assert(value>=0);
		assert(lottery >= ILotteryCompany.MINIMUM_LOTTERY);
		assert(lottery <= ILotteryCompany.MAXIMUM_LOTTERY);
	}
}
