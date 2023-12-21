package _11콜렉션Member;

import java.util.HashMap;
import java.util.Map;
// 화면 -> url(String value) -> DAO 연결해주는 클래스
public class Controller {
	
	private Controller() {
		init();
	}
	
	static private Controller instance = new Controller();
	
	public static Controller getInstance() {
		return instance;
	}
	
	private Map<String, Action> mapList;
	
	private void init() {
		mapList = new HashMap<>();
		mapList.put("insert", new ActionInsert());
		mapList.put("delete", new ActionDelete());
		mapList.put("update", new ActionUpdate());
		mapList.put("print", new ActionPrint());
		mapList.put("save", new ActionSave()); 
		mapList.put("load", new ActionLoad());
	}
	
	public Action getAction(String key) {
		return mapList.get(key);
	}
}
