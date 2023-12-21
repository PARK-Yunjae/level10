package _11콜렉션Member;

import java.util.Scanner;

public class Util {
	static Scanner sc = new Scanner(System.in);
	private static final String CUR_PATH = System.getProperty("user.dir") + "//src//"+Util.class.getPackageName()+"//";

	public static String getCurPath() {
		return CUR_PATH;
	}

	public static int intValue(String msg, int start, int end) {
		System.out.print(msg);
		int sel = -1;
		try {
			sel = sc.nextInt();
			if(sel < start  || sel > end) {
				System.out.println("범위 오류");
				return -1;
			}
		}catch (Exception e) {
			System.out.println("숫자를 입력해 주세요");
		}
		return sel;
	}
	
	public static String strValue(String msg) {
		System.out.print(msg);
		return sc.next();
	}
}
