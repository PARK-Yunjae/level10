package _15쓰레드;

import java.util.Scanner;

class SingASong implements Runnable{

	int max;
	
	public SingASong(int max) {
		this.max = max;
	}

	@Override
	public void run() {
		String lyric="%s : %d + %d는 귀요미";
		
		for(int i=1 ; i<=max ; i+=1) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("내 노래는 좋다");
				return;
//				e.printStackTrace();
			}
			
			System.out.printf(" %s %n", lyric.formatted(Thread.currentThread().getName(), i, i));
		}
	}
	
}

public class _04쓰레드이론04 {
	public static void main(String[] args) {
		Thread singASong = new Thread(new SingASong(10));
		singASong.setName("귀여미송");
		
		singASong.start();
		
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				String command = sc.nextLine();
				
				if(command.equals("check")) {
					System.out.println("노래 끝났나?");
					System.out.println(singASong.isAlive() ? "아니" : "응 끝났어");
				}
				
				if(command.equals("stop")) {
					System.out.println("loud?");
					singASong.interrupt();
					// 셋다 쓰지말라고 권장함
//					singASong.stop();	강제로 멈춰라
//					singASong.suspend();강제로 연결해라
//					singASong.resume(); 강제로 끊어라?
				}
				
				if(command.equals("join")) {
					System.out.println("나도 껴줘");
					try {
						singASong.join(3000);// 비동기를 동기로 만들어줌
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
