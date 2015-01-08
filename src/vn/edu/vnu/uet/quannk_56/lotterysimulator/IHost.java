package vn.edu.vnu.uet.quannk_56.lotterysimulator;

public interface IHost {
	boolean RegistAPlayer(int id, int captital);
	
	boolean recharge(int id, int money);
	
	int GetPlayerCapital(int id);
}
