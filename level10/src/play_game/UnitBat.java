package play_game;

public class UnitBat extends Unit {
	@Override
	public void Skill(Unit target) {
		System.out.println("[박쥐] 적 한명에게 침묵");
		target.setCc(true);
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