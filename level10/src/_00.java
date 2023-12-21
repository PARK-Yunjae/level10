

import java.util.Arrays;
import java.util.Scanner;

public class _00 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s1 = sc.next();
        String s2 = sc.next();
        
        int num1 = 0;
        int num2 = 0;
        
        int m = 1;
        for(int i = 0 ; i<s1.length() ; i++){
            num1 += (s1.charAt(i)-'0')*m;
            m *= 10;
        }        
        m = 1;
        for(int i = 0 ; i<s2.length() ; i++){
            num2 += (s2.charAt(i)-'0')*m;
            m *= 10;
        }
        System.out.println(num1 > num2 ? num1 : num2);
	}
}