package game_실습용;

import java.util.Random;

public class KnuckleMan extends Unit implements Attacker {
	// 생성자
	public KnuckleMan(Side side, int hp) {
		super(side, hp);
	}

	// 생성자 2
	public KnuckleMan(int hp) {
		super(Side.WHITE, hp);
	}

	// 기본공격
	private void KnuckleAttack(Unit target) {
		target.setHp(target.getHp() - 10);
	}

	// 실제로 불러오는 공격 메서드
	@Override
	public void defaultAttack(Unit target) {
		System.out.println("%s 가 %s 기본 어택! %n".formatted(this, target));
		if (defaultDefander(target)) {
			KnuckleAttack(target);
		}
		System.out.println(target);
	}

	// 나의 hp 출력
	@Override
	public String toString() {
		return getSide().toString() + " 진영 검사(" + this.getHp() + ")";
	}

	private boolean defaultDefander(Unit target) {
		if (target instanceof Shilder) {
			Random rd = new Random();
			int num = rd.nextInt(2);
			if (num == 0) {
				System.out.println("방어 성공");
				return false;
			} else {
				System.out.println("방어 실패");
			}
		}
		return true;
	}
}