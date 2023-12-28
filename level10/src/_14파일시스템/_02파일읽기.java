package _14파일시스템;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class _02파일읽기 {
	public static void main(String[] args) {
		String path = "src\\_14파일시스템";
		Path txtPath = Paths.get(path, "test.txt");
		System.out.println(Files.exists(txtPath));
		
		List<String> lines = Arrays.asList(
				"한번더 나에게 질풍같은 용기를", 
				"거친 파도에도 굴하지 않게",
				"드넓은 대지에 다시 새길 희망을",
				"안고 달려갈거야 너에게",
				"너에게");
		
		try {
			Files.write(txtPath, lines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] path4Bytes = new byte[1];
		// 대용량 파일에 부적합
		try {
			path4Bytes = Files.readAllBytes(txtPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String result = new String(path4Bytes);
		System.out.println(result);
		
		// 파일 복사
		Path copied = Paths.get(txtPath.getParent().toString(), "moved.txt");
		try {
			Files.copy(txtPath, copied);
			System.out.println("복사 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 파일 이동
		Path moved = Paths.get(txtPath.getParent().getParent().toString(), "moved.txt");
		
		try {
			Files.move(copied, moved);
			System.out.println("이동 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 파일 삭제
		try {
			Files.delete(moved);
			System.out.println("삭제 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
