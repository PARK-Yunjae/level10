package _11콜렉션Member;

public class ActionInsert implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		// 맴버 추가하는 페이지
		System.out.println("맴버 추가하기");
		String id = Util.strValue("ID >>");
		if(dao.isValueId(id)) {
			System.out.println("이미 사용하는 아이디");
			return;
		}
		String pw = Util.strValue("PW >>");
		
		dao.InsertMember(id, pw);
	}	
}
