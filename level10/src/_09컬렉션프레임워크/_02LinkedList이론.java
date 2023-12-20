package _09컬렉션프레임워크;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class _02LinkedList이론 {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		
		// 보무 타입이기 때문에 값 변경에 유연성이 있다.
//		list1 = new LinkedList<>();

		LinkedList<Integer> list2 = new LinkedList<Integer>(Arrays.asList(50, 40, 30, 20, 10));

		System.out.println(list1);
		System.out.println(list2);
		
		list1.remove(1); // 1번째 방 사라짐
		list1.remove((Integer) 1); // 값 1이 사라짐

		System.out.println(list1);
		System.out.println(list2);

		list1.add(0, 100);
		System.out.println(list1);
		list1.add(1, 20);
		System.out.println(list1);

		Collections.sort(list2);
		System.out.println(list2);
		
		// 링크드리스트안에 스택 구현되어 잇따.
		LinkedList<Character> list3 = new LinkedList<Character>();
		list3.push('a');
		list3.push('b');
		list3.push('c');
		list3.push('d');
		list3.push('e');

		System.out.println(list3);

		System.out.println(list3.pop());
		System.out.println(list3.pop());
		System.out.println(list3.pop());
		
		System.out.println(list3);
	}
}
