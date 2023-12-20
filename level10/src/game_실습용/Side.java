package game_실습용;

public enum Side {
	WHITE("화이트"), BLACK("블랙");
	
	private String name;
	// 생성자 저장할때
	private Side(String name) {
		this.name = name;
	}
	// 팀명 불러오기
	public String getName() {
		return name;
	}
}