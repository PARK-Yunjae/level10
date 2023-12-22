package play_game;

import java.util.Random;

public class UnitManager{
	private String path = UnitManager.class.getPackageName() + ".";
	private String[] className = {"UnitWorrior", "UnitThirf", "UnitHunter",
									"UnitOrc", "UnitBat", "UnitWolf"};
	private String[] unitName = {"전사", "도적", "궁수", "오크", "박쥐", "늑대"};
	private Random rd = new Random();
	
	public Unit Unit_Rand_Set(int hp, int max) {
		int idx = rd.nextInt(className.length);
		Unit temp = null;
		try {
			Class<?> clazz = Class.forName(path + className[idx]);
			Object obj = clazz.getDeclaredConstructor().newInstance();
			temp = (Unit)obj;
			int maxhp = rd.nextInt(100) + hp;
			int maxpower = rd.nextInt(10) + max;
			temp.init(unitName[idx], maxpower, maxhp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
}