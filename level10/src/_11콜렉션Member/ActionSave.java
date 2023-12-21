package _11콜렉션Member;

import java.io.FileWriter;
import java.io.IOException;

public class ActionSave implements Action {

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();

		String fileName = "member.txt";
		String data = "";
		
		String msg = "";
		for (int i = 0; i < dao.getMemberList().size(); i += 1) {
			data += dao.getMemberList().get(i).dataToFile()+"\n";
		}
		
		try (FileWriter fw = new FileWriter(Util.getCurPath() + fileName)) {
			fw.write(data);
			msg = fileName + "저장 성공";
		} catch (IOException e) {
			msg = fileName + "저장 실패";
		}
		
		dao.SaveMember(msg);
	}
}
