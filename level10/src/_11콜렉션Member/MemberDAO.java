package _11콜렉션Member;

import java.util.ArrayList;

// 데이터를 차리하는 애
public class MemberDAO {

	private MemberDAO() {
		init();
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	private ArrayList<Member> memberList;

	private void init() {
		memberList = new ArrayList<Member>();
	}

	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	public void InsertMember(String id, String pw) {
		Member member = new Member(id, pw);
		memberList.add(member);
		System.out.println(member + "추가 완료");
	}

	public void DeleteMember(String id, int idx) {
		memberList.remove(idx);
		System.out.println(id + "삭제 완료");
	}

	public void UpdateMember(String id, String pw, int idx) {
		Member member = new Member(id, pw);
		memberList.set(idx, member);
		System.out.println(member + "수정 완료");
	}

	public void PrintMember(String data) {
		System.out.println(data);
	}

	public void SaveMember(String msg) {
		System.out.println(msg);
	}

	public void LoadMember(String data) {
		if(data.equals(""))
			return;
		String[] datas = data.split("\n");
		memberList.clear();
		for(int i=0 ; i<datas.length ; i+=1) {
			String[] info = datas[i].split("/");
			memberList.add(new Member(info[0], info[1]));
		}
	}

	public boolean isValueId(String id) {
		if (memberList.size() == 0)
			return false;
		for (Member m : memberList) {
			if (m.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public int isValueIdPw(String id, String pw) {
		if (memberList.size() == 0)
			return -1;
		for (int i = 0; i < memberList.size(); i += 1) {
			if (memberList.get(i).getId().equals(id) && memberList.get(i).getPw().equals(pw)) {
				return i;
			}
		}
		return -1;
	}
}
