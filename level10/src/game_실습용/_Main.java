package game_실습용;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Main {
	public static void main(String[] args) {
		// 팀당 3명씩
		KnuckleMan w_knuckleMan = new KnuckleMan(100);
		Knight w_knight = new Knight(200);
		Mage w_mage = new Mage(80);
		
		Shilder b_shilder = new Shilder(Side.BLACK, 120);
		Knight b_knight = new Knight(Side.BLACK, 210);
		Mage b_mage = new Mage(Side.BLACK, 100);
		
		// 말은 한마리씩만 줘봅시다
		Horse<Shilder> black = new Horse<>(60);
		Horse<Knight> white = new Horse<>(30);
		
		black.setRider(b_shilder);
		white.setRider(w_knight);
		
		System.out.println("----------");
		// 팀은 같은 유닛을 들고 있으니 넣어주고
		List<Unit> wTeam = new ArrayList<>(Arrays.asList(w_knuckleMan,w_knight, w_mage ));
		List<Unit> bTeam = new ArrayList<>(Arrays.asList(b_shilder,b_knight, b_mage ));
		
		for(Unit u : wTeam) {
			System.out.println(u);
		}
		
		for(Unit u : bTeam) {
			System.out.println(u);
		}
		
		System.out.println("----------");
		
		w_knuckleMan.defaultAttack(b_mage);
		w_knight.defaultAttack(b_shilder);
		w_knight.switchWeapon();
		w_knight.defaultAttack(b_knight);
		
		b_shilder.defaultAttack(w_mage);
		b_knight.defaultAttack(b_shilder);
		b_mage.fireballAttack(bTeam.toArray(new Unit[bTeam.size()]));
	}
}