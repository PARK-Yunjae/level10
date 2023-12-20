package game_실습용;

public class Mage extends KnuckleMan {
	private int mana = 100;
	private final int MANA_USAGE = 50;

	// 생성자1
	public Mage(Side side, int hp) {
		super(side, hp);
	}

	// 입력이 없으면 기본적으로 하얀팀
	public Mage(int hp) {
		super(Side.WHITE, hp);
	}

	// 마법 공격 - 광역 공격
	public void fireballAttack(Unit[] targets) {
		for (Unit target : targets) {
			if (mana < MANA_USAGE) {
				break;
			}
			System.out.println("Fire in the hole - %s 사망".formatted(target));
			target.setHp(0);
			System.out.println(target);
			mana -= MANA_USAGE;
		}
	}

	@Override
	public String toString() {
		return getSide().toString() + " 진영 마법사 (" + this.getHp() + ")";
	}

}