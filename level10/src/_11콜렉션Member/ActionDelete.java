package _11콜렉션Member;

public class ActionDelete implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		if(dao.getMemberList().size()==0) {
			System.out.println("삭제할 데이터가 없습니다");
			return;
		}
		System.out.println("맴버 삭제하기");
		String id = Util.strValue("ID >>");
		if(!dao.isValueId(id)) {
			System.out.println("아이디가 없습니다");
			return;
		}
		String pw = Util.strValue("PW >>");
		int idx = dao.isValueIdPw(id,pw);
		if(idx == -1) {
			System.out.println("아이디와 비밀번호가 일치하지 않습니다");
			return;
		}
		dao.DeleteMember(id, idx);
	}

}
