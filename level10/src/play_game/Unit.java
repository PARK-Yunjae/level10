package play_game;

import java.util.Random;

public abstract class Unit implements UnitCommand{
	private int curhp;
	private int maxhp;
	private int power;
	private int max;
	private String name;
	private boolean cc;
	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getName() {
		return name;
	}

	public void setCurhp(int curhp) {
		this.curhp = curhp;
	}

	public boolean isCc() {
		return cc;
	}

	public void setCc(boolean cc) {
		this.cc = cc;
	}

	public Unit() {}
	
	public Unit(int hp, int max, String name) {
		this.curhp = hp;
		this.maxhp = hp;
		this.max = max;
		this.name = name;
	}
	
	public int getCurhp() {
		return curhp;
	}

	public void init(String name, int max, int hp) {
		this.curhp = hp;
		this.maxhp = hp;
		this.max = max;
		this.name = name;
	}

	public void attack(Unit target) {
		Random rd = new Random();
		power = rd.nextInt(max)+1;
		target.curhp -= power;
		System.out.println("[%s] 이 [%s] 에게 %d 의 대미지를 입힘".formatted(name, target.name, power));
		if(target.curhp <= 0) {
			System.out.println("[%s] 는 죽음".formatted(target.name));
			target.curhp = 0;
		}
	}
	
	public void printData() {
		System.out.println("[%s][%d/%d][%d]".formatted(name, curhp, maxhp, max));
	}

}