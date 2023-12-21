package _11콜렉션Member;

public class ActionUpdate implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		if(dao.getMemberList().size()==0) {
			System.out.println("수정할 데이터가 없습니다");
			return;
		}
		// 맴버 수정하는 페이지
		System.out.println("맴버 수정하기");
		String id = Util.strValue("ID >>");
		String pw = Util.strValue("PW >>");
		int idx = dao.isValueIdPw(id, pw);
		if(idx == -1) {
			System.out.println("아이디와 비밀번호가 일치하지 않습니다");
			return;
		}
		pw = Util.strValue("변경할 PW >>");
		
		
		dao.UpdateMember(id,pw,idx);
		
	}
}
