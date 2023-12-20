package game_실습용;

public abstract class Unit {
	private Side side;
	private int hp;
	//hp 불러오기
	public int getHp() {
		return hp;
	}
	// hp 다시 쓰기?
	public void setHp(int hp) {
		this.hp = hp;
	}
	// 생성자
	public Unit(Side side, int hp) {
		this.side = side;
		this.hp = hp;
	}
	// 사이드 불러오기 - 팀 진영
	public Side getSide() {
		return side;
	}
}