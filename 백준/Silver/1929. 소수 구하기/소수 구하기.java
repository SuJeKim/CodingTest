import java.util.Scanner;

public class Main {

	public static void main(String[] args) {			
			Scanner scan = new Scanner(System.in);
			
			int firstNum = scan.nextInt();
			int lastNum = scan.nextInt();
			StringBuilder sb = new StringBuilder();
			
            // 소수 확인 변수(true ⇒ 소수, false⇒소수 아님)         
			boolean isPrime = true;
        
            // 1은 소수가 아님. 미리 거르기.
            if(firstNum == 1) {
			firstNum += 1;
		    } 
        
			//숫자 하나씩 뽑아서 소수 판별	
			for(int i = firstNum; i <= lastNum; i++) {
					for(int j = 2; j<=Math.sqrt(i); j++) {
						if( i%j == 0 ) {
							isPrime = false;
							break;
						}
					}
					
					if(isPrime) {
						sb.append(i).append("\n"); // StringBuilder 객체 사용
					}
					isPrime = true;
			}
			
			System.out.println(sb);

		}

	}