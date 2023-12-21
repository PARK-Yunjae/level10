package _11콜렉션Member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ActionLoad implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		String fileName = "member.txt";
		String data = "";
		try (FileReader fr = new FileReader(Util.getCurPath() + fileName); 
				BufferedReader br = new BufferedReader(fr)) {
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				data += line + "\n";
			}
			if (data.length() != 0)
				data = data.substring(0, data.length() - 1);
			System.out.println(fileName + "로드 성공");
		} catch (IOException e) {
			System.out.println(fileName + "로드 실패");
		}
		dao.LoadMember(data);
	}
}
