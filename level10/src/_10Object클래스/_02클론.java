package _10Object클래스;

class Bag {
	String contains;

	public Bag(String contains) {
		super();
		this.contains = contains;
	}

	@Override
	public String toString() {
		return "가방 속 = " + contains;
	}

}

class Person implements Cloneable {
	String name;
	int age = 10;
	Bag bag;

	public Person(String name, Bag bag) {
		super();
		this.name = name;
		this.bag = bag;
	}

	@Override
	public String toString() {
		return name + " : " + age + " : " + bag;
	}

	public Person clone() {
		try {
			Object obj = super.clone();
			return (Person) obj;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e);
		}
	}
}

public class _02클론 {
	public static void main(String[] args) {
		Bag bag1 = new Bag("갤럭시탭");
		Bag bag2 = new Bag("노트북");
		Person p1 = new Person("홍길동", bag1);
//		얕은 복사
		Person p2 = p1;
		p2.name = "김선달";
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("-----------");
//		깊은 복사
		Person p3 = new Person(p1.name, bag2);
		System.out.println(p1);
		System.out.println(p3);
		System.out.println("-----------");
		p3.name = "국간장";
		System.out.println(p3);
		System.out.println("-----------");
		Person p4 = p1.clone();
		System.out.println(p1);
		System.out.println(p4);
		System.out.println("-----------");
		p1.bag = new Bag("그램");
		p4.name = "진간장";
		p4.age = 10;
		System.out.println(p1);
		System.out.println(p4);
		System.out.println("-----------");
	}
}