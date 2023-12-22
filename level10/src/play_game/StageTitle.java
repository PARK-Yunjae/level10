package play_game;

public class StageTitle implements Stage{

	@Override
	public boolean update() {
		System.out.println("=====[TEXT RPG]=====");
		System.out.println("[아무키나 누르시오]");
		GameManager.sc.nextLine();
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
	}
	
}