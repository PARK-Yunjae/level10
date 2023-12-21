package _11콜렉션Member;

public class _Main {
	public static void main(String[] args) {
		Controller con = Controller.getInstance();
		
		while (true) {
			System.out.println("========== 메뉴 ==========");
			System.out.println("1) 추가");
			System.out.println("2) 삭제");
			System.out.println("3) 수정");
			System.out.println("4) 출력"); // id 이름순
			System.out.println("5) 저장");
			System.out.println("6) 로드");
			System.out.println("0) 종료");
			
			int sel = Util.intValue("입력 >>", 0, 6);

			if(sel == 1) {
				con.getAction("insert").excute();
			}else if(sel == 2) {
				con.getAction("delete").excute();
			}else if(sel == 3) {
				con.getAction("update").excute();
			}else if(sel == 4) {
				con.getAction("print").excute();
			}else if(sel == 5) {
				con.getAction("save").excute();
			}else if(sel == 6) {
				con.getAction("load").excute();
			}else if(sel == 0) {
				System.out.println("종료");
				Util.sc.close();
				break;
			}
		}
	}
}
