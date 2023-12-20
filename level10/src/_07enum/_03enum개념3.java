package _07enum;

import java.util.ArrayList;

enum PizzaMenu{
	
	PP("페페로니피자", 10000, 0),
	CP("치즈피자", 12000, 0),
	SP("스파이스소세지피자", 14000, 2),
	MP("마라피자", 13000, 3),
	HP("하와이안피자", 13000, 0),
	BP("바베큐피자", 13000, 1);
	
	private String name = "";
	private int price;
	private int spicyLevel;
	
	private PizzaMenu(String name, int price, int spicyLevel) {
		this.name = name;
		this.price = price;
		this.spicyLevel = spicyLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSpicyLevel() {
		return spicyLevel;
	}

	public void setSpicyLevel(int spicyLevel) {
		this.spicyLevel = spicyLevel;
	}
	
	public String getDesc() {
		String peppers = "";
		if(spicyLevel > 0) {
			peppers = "매움".repeat(spicyLevel);
		}
		return "%s %s원 %s".formatted(name, price, peppers);
	}
	
	static PizzaMenu getMenu(String name) {
		for(PizzaMenu menu : PizzaMenu.values()) {
			if(name.equals(menu.getName())) {
				return menu;
			}
		}
		return null;
	}
} 

class PizzaStore{
	PizzaMenu[] menues = PizzaMenu.values();
	
	void takeOrder(String name) {
		PizzaMenu menu = PizzaMenu.getMenu(name);

		if(menu == null) {
			System.out.println("피자가 존재하지 않습니다");
			return;
		}
		
		System.out.println(menu.getPrice() + "원 입니다");
	}
}
public class _03enum개념3 {
	public static void main(String[] args) {
		ArrayList<PizzaMenu> list = new ArrayList<PizzaMenu>();
		list.add(PizzaMenu.CP);
		list.add(PizzaMenu.PP);
		list.add(PizzaMenu.MP);
		list.add(PizzaMenu.SP);
		list.add(PizzaMenu.BP);
		list.add(PizzaMenu.HP);
		
		String[] names = new String[list.size()];
		int[] orders = new int[list.size()];
		
		int idx = 0;
		for(PizzaMenu menu : list) {
			names[idx] = menu.name();
			orders[idx++] = menu.ordinal();
		}
		
		for(int i=0 ; i< list.size() ; i+=1) {
			System.out.println("name = %s order = %d".formatted(names[i], orders[i]));
		}
		
		for(PizzaMenu menu : list) {
			System.out.println(menu.getDesc());
		}
		
		PizzaStore store = new PizzaStore();
		for(String menu : "페페로니피자,마라피자,땡초피자,바베큐피자".split(",")) {
			store.takeOrder(menu);
		}
	}
}
