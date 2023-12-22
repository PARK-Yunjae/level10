package play_game;

import java.util.Random;

public class UnitOrc extends Unit {
	@Override
	public void Skill(Unit target) {
		Random rd = new Random();
		this.setPower((rd.nextInt(this.getMax())+1)*2);
		target.setCurhp(target.getCurhp()-this.getPower());
		System.out.println("[%s] 이 [%s] 에게 %d(두배) 의 대미지를 입힘".formatted(getName(), target.getName(), this.getPower()));
		target.setCc(true);
		if(target.getCurhp() <= 0) {
			System.out.println("[%s] 는 죽음".formatted(target.getName()));
			target.setCurhp(0);
		}
	}

	@Override
	public void attack(Unit target, int critical) {
		if (critical == 0) {
			Skill(target);
		} else {
			super.attack(target);
		}
	}
}