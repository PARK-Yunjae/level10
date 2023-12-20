package game;

public class Horse<T extends Unit> {	// 유닛을 상속받은 어떤 클래스타입이 올 수 있다
	private int extraHp;
	private T rider;

	public T getRider() {
		return rider;
	}

	public Horse(int extraHp) {
		this.extraHp = extraHp;
	}

	public Horse() {
	}

	public void setRider(T rider) {
		System.out.printf("%s가 말에 올라탔다 ", rider);
		this.rider = rider;
		rider.hp += extraHp;
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "말 (추가체력: %d)".formatted(extraHp);
	}
}