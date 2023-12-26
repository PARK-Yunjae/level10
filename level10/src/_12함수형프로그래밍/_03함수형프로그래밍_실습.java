package _12함수형프로그래밍;

import java.util.function.BinaryOperator;

class Calculate{
	static int add(int a,int b) {return a+b;}
	static int subract(int a,int b) {return a-b;}
	static int multiply(int a,int b) {return a*b;}
}

@FunctionalInterface
interface Add{
	int add(int a, int b);
}

@FunctionalInterface
interface Subract{
	int subract(int a, int b);
}

@FunctionalInterface
interface Multiply{
	int multiply(int a, int b);
}

public class _03함수형프로그래밍_실습 {
	public static void main(String[] args) {
		System.out.println(Calculate.add(10, 20));
		System.out.println(Calculate.subract(10, 20));
		System.out.println(Calculate.multiply(10, 20));

		System.out.println("==========");
		Add add = (int a, int b) -> {return a+b;};
		Subract sub = (a, b) -> a-b;
		Multiply mul = (int a, int b) -> a*b;
		
		System.out.println(add.add(10, 20));
		System.out.println(sub.subract(20, 30));
		System.out.println(mul.multiply(3, 5));
		
		BinaryOperator<Integer> add2 = (a, b) -> a+b;
		System.out.println(add2.apply(10, 20));
	}
}
