package play_game;

public class _MainGame{
	public static void main(String[] args) {
		GameManager gm = new GameManager();
		while(gm.changeStage());
		System.out.println("게임 종료");
	}
}