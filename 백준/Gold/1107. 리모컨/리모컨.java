import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int channel = sc.nextInt();
		int m = sc.nextInt();
		
		// 고장난 버튼 배열 입력 true -> 고장
		boolean[] errorButton = new boolean[10];
		for(int i = 0; i < m; i++) {
			errorButton[sc.nextInt()] = true;
		}
		
		if(channel == 100) {
			System.out.println(0);
			return;
		}
		
		// +/-로만 가는 경우
		int result = Math.abs(channel - 100);
		
		// 근사 값에서 +/-로 가는 경우
		// 1. 현 채널(I)의 길이만큼 i 채널의 각 자리 수가 고장난 버튼인지 확인
		// 2.  현 채널(I) 만들 수 있으면 
		//		근사 값에서 +/-로 가는 횟수 + 숫자 버튼을 누르는 횟수 
		for(int i = 0; i <= 999_999; i++) {
			String presentChannel = String.valueOf(i);
			
			boolean isError = false;
			for(int j = 0; j < presentChannel.length(); j++) {
				if(errorButton[presentChannel.charAt(j) - '0']) {
					isError = true;
					break;
				}
			}
			if(!isError) {
				int value = Math.abs(channel - i) + presentChannel.length();
				result = Math.min(result, value);
			}
		}
		System.out.println(result);
	}

}
