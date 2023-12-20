package game_실습용;

public class Shilder extends Unit implements Attacker{
	public Shilder(Side side, int hp) {
		super(side, hp);
	}

	// 기본 공격
	@Override
	public void defaultAttack(Unit target) {
		System.out.println("%s 가 %s 기본 공격!".formatted(this, target));
		target.setHp(target.getHp()-10);

		System.out.println(target);
	}

	// 체력 출력
	@Override
	public String toString() {
		return getSide().toString() + " 진영 방패전사 (" + this.getHp() + ")";
	}
}
