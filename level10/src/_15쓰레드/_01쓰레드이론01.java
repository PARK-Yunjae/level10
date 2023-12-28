package _15쓰레드;

class Thread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 20; i += 1) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(1);
		}
	}
}

class myRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 20; i += 1) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(2);
		}
	}

}

public class _01쓰레드이론01 {
	// 동기적 : 메모리 호출 순서로 순차적으로 실행
	// 비동기적 : 호출 될 때 다른 곳에서 실행, 현재 실행하는 것은 멈추지 않는다
	public static void main(String[] args) {
		System.out.println("메인 쓰레드 영역");

		// 쓰레드를 상속 받았을 때
		Thread thread1 = new Thread1();

		// Runnable 구현했을 때
		Thread thread2 = new Thread(new myRunnable());

		// 메인쓰레드에서 동기적으로 호출해서 처리
//		thread1.run();
//		System.out.println();
//		thread2.run();
//		System.out.println();
//		for(int i = 0 ; i < 20 ; i += 1) {
//			System.out.print('M');
//		}

//		thread1.start();
//		thread2.start();
//		for (int i = 0; i < 20; i += 1) {
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.print('M');
//		}

		// Runnable 익명 클래스 생성
		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 20; i += 1) {
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.print(3);
				}
			}

		});

		// 익명 클래스의 람다식 표현 (@FunctionalInterface) 일때 가능
		Thread thread4 = new Thread(() -> {
			for (int i = 0; i < 20; i += 1) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(4);
			}
		});
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		for (int i = 0; i < 20; i += 1) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print('M');
		}
	}
}
