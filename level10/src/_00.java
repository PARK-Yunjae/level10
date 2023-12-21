
import java.util.Scanner;

public class _00 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            String str = sc.nextLine();
            if(str == null || str.equals("")){
                break;
            }
            System.out.println(str);
        }
	}
}