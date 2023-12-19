package _05인터페이스;

/* 추상클래스 vs 인터페이스

// 인터페이스는 다중 상속이 목적이다.
// 인터페이스는 추상 클래스보다 더 추상적이다.
// 인터페이스 자체는 객체를 생성하는 목적이 아니다.

	       | 추상 클래스				| 인터페이스
개념 		   | 물려받는 것(혈통, 가문, 계열)	| 장착 (기능(행위), 학위, 자격증)
다중적용	   | 불가능(부모는 하나)			| 가능
생성자	   | 가짐						| 가지지 않음
메서드	   | 구상, 추상 모두 가능			| 추상메서드, default(완성된 메서드), static
필드(맴버변수) | 모두 가능					| 상수 변수(static final)
적용방식	   | extends (확장)			| implements (구현)

추상클래스 : 동물 식물 기계
인터페이스 : movable flyable eatable swimable aboardable

자동차 : 기계 : movable, aboardable
비행기 : 기계 : movable, flyable, aboardable
새	 : 동물 : movable, flyable, eatable, swimable, aboardable
사람	 : 동물 : movable, swimable
오리배 : 기계 : movable, swimable, aboardable 
*/
abstract class A {
//	public static final int num = 10;
//	public abstract void test3();
	int a = 20;
	void test1() {
		System.out.println("test1 호출했다.");
	}

	abstract void test2();
}

class B extends A { // 클래스는 여러개 상속이 불가능하다 단 한개만 상속이 가능하다
	int num = 10;

	@Override
	void test2() {
		System.out.println("test2 호출했다.");
	}
}

interface E1 {
	int num = 20; // public static final int num

	void test3(); // public abstract void test3();
}

interface E2 {
	void test4();
}

interface E3 extends E2{
	void test5();
	
	default void test7() {
		
	}
	
	static void test6() {
		
	}
}

class C extends B implements E1, E2{

	@Override
	public void test4() {
		System.out.println("test4 호출했다");
	}

	@Override
	public void test3() {
		System.out.println("test3 호출했다");
	}

	@Override
	void test2() {
		System.out.println("test2 호출했다");
	}
	
}

class D implements E3{

	@Override
	public void test4() {
		System.out.println("test4 호출했다");
	}

	@Override
	public void test5() {
		System.out.println("test5 호출했다");
	}
	
}
public class _01인터페이스_개념 {
	public static void main(String[] args) {
//		B b1 = new B();
//		A b2 = new B();
//		
//		C c1 = new C();
//		B c2 = new C();
//		A c3 = new C();
//		E1 c4 = new C();
////		c4.num = 100; 안도미
//		E2 c5 = new C();
		
		
	}
}
