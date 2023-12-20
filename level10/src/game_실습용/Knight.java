package game_실습용;

public class Knight extends KnuckleMan {
	// 두가지 무기를 사용하기 위해 enum
	private enum Weapon {
		MACE, KNUCKLE
	}
	// 기본 무기는 주먹
	private Weapon weapon = Weapon.KNUCKLE;
	// 생성자
	public Knight(Side side, int hp) {
		super(side, hp);
	}
	// 또다른 생성자?
	public Knight(int hp) {
		super(Side.WHITE, hp);
	}
	// 무기 교체
	public void switchWeapon() {
		weapon = weapon == Weapon.KNUCKLE ? Weapon.MACE : Weapon.KNUCKLE;
	}
	// 주먹 공격
	@Override
	public void defaultAttack(Unit target) {
		if (weapon == Weapon.KNUCKLE) {
			super.defaultAttack(target);
		}else {
			MaceAttack(target);
		}
	}
	// 둔기 공격
	private void MaceAttack(Unit target) {
		System.out.println("%s 가 %s 둔기 어택! \n".formatted(this, target));
		target.setHp(target.getHp()-15);
		System.out.println(target);
	}
	// 나의 hp 출력
	@Override
	public String toString() {
		return getSide().toString() + " 진영 기사 (" + this.getHp() + ")";
	}
}