import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		
		StringBuilder sb = new StringBuilder();
		
		// 8진수 -> 2진수
		for(int i = 0; i<number.length(); i++) {
			// 숫자 문자를 정수로 변환 ASCII 값 활용
			// 10진수변환
			String bi = Integer.toBinaryString(number.charAt(i) - '0');
			
			// 첫번째 인덱스가 아닐 경우에는 세자리 수로 구현해야 함.
			if(bi.length() == 2 && i != 0) {
				bi = '0' + bi;
			} else if(bi.length() == 1 && i != 0) {
				bi = "00" + bi;
			}
			
			sb.append(bi);
		}
		System.out.println(sb);

	}

}
