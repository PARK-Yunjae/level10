package _11콜렉션Member;

import java.util.ArrayList;
import java.util.Collections;

public class ActionPrint implements Action{
	
	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		String data = "";
		@SuppressWarnings("unchecked")
		ArrayList<Member> copy = (ArrayList<Member>) dao.getMemberList().clone();
		Collections.sort(copy);
		
		for(int i=0 ; i<dao.getMemberList().size() ; i+=1) {
			data += dao.getMemberList().get(i) + "\n";
		}
		data += "-------------\n";
		for(int i=0 ; i<copy.size() ; i+=1) {
			data += copy.get(i) + "\n";
		}
		
		dao.PrintMember(data);
	}
}
