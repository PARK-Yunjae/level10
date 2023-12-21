package _11콜렉션Member;

import java.util.ArrayList;

public class ActionPrint implements Action{
	
	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		String data = "";
		ArrayList<Member> copy = dao.getMemberList();
		
		for(int i=0 ; i<copy.size() ; i+=1) {
			for(int k=0 ; k<copy.size() ; k+=1) {
				if(copy.get(i).getId().charAt(0) < copy.get(k).getId().charAt(0)) {
					Member info = copy.get(i);
					copy.set(i, copy.get(k));
					copy.set(k, info);
				}
			}
		}
		
		for(int i=0 ; i<copy.size() ; i+=1) {
			data += copy.get(i) + "\n";
		}
		
		dao.PrintMember(data);
	}
}
