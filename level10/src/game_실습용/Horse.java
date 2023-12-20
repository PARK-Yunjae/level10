package game_실습용;

public class Horse<T extends Unit> {	// 유닛을 상속받은 어떤 클래스타입이 올 수 있다
	private int extraHP;
	private T rider;
	
	public T getRider() {
		return rider;
	}

	public Horse(int extraHP) {
		this.extraHP = extraHP;
	}
	
	public Horse() {
	}
	
	public void setRider(T rider) {
		System.out.println("%s가 말에 탑승".formatted(rider));
		this.rider = rider;
		rider.setHp(rider.getHp()+extraHP);
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "말 (추가체력 %d)".formatted(extraHP);
	}
	
}