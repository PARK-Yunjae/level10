package _09컬렉션프레임워크;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class _05Map이론 {
	public static void main(String[] args) {

		Map<String, Integer> list = new HashMap<>();
		list.put("apple", 10000);
		list.put("orange", 200);
		list.put("melon", 15000);
		list.put("wAtEr MeLoN", 20000);

		list.put("apple", 2000);

		System.out.println(list);
		System.out.println(list.get("orange"));
		System.out.println(list.size());

		Set<String> listKeys = list.keySet();

		for (String s : listKeys) {
			System.out.println(s + " " + list.get(s));
		}

		System.out.println(list.containsKey("apple"));
		System.out.println(list.containsKey("banana"));
		System.out.println(list.containsValue(1000));
		//	Map 생략 가능
		Set<Map.Entry<String, Integer>> list2 = list.entrySet();
		
		for(Entry<String, Integer> entry : list2) {
			System.out.println(entry);
//			System.out.println("%s %d ".formatted(entry.getKey(), entry.getValue()));
		}
	}
}
