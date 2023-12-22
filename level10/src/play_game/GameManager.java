package play_game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameManager{
	public static Scanner sc = new Scanner(System.in);
	public static String nextStage = "TITLE";
	private String curStage = "";
	private Map<String , Stage> stageList = new HashMap<String, Stage>();
	
	public GameManager() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
	}
	
	public static int selValue(String msg, int start, int end) {
		int sel = -1;
		try {
			sel = sc.nextInt();
			if(sel < start || sel > end) {
				System.out.println("범위 오류");
				return -1;
			}
		}catch (Exception e) {
			System.out.println("숫자를 입력하세요");
		}
		return sel;
	}
	
	public boolean changeStage() {
		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);
		
		if(curStage.equals(nextStage)) return true;
		
		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();
		
		while(stage.update());
		
		if(nextStage.equals("")) return false;
		else return true;
	}
}