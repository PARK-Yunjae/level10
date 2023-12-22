package play_game;

import java.util.ArrayList;
import java.util.Random;

public class BattleManager {
	public int attackIdx(ArrayList<Unit> u) {
		Random rd = new Random();
		int idx = 0;
		while (true) {
			idx = rd.nextInt(u.size());
			if (u.get(idx).getCurhp() > 0) {
				break;
			}
		}
		return idx;
	}
}
