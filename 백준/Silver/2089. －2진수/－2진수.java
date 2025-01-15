import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		if(n == 0) {
			sb.append(n);
		}else {
			while(n != 1) {
				sb.append(Math.abs(n % (-2)));
				
				//N을 재설정 ⇒ 몫을 올림
				n = (int)Math.ceil((double)n / (-2));
			}
			sb.append(n);
		}
		System.out.println(sb.reverse());

	}

}
