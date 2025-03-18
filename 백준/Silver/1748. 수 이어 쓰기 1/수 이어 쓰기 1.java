import java.util.*;
import java.lang.*;

public class Main {

	public static void main(String[] args) {
		int count = 0; // 자릿수(출력값)
		int plus = 1; // 자릿수에 더할 값
		int val = 10; // 자릿수 판단. 나눠야 할 값.
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			
			if(i % val == 0) {
				plus++;
				val *= 10;
			}
			count += plus;
		}
		System.out.println(count);
		
	}

}
