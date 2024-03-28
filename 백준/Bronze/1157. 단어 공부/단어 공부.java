import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toUpperCase(); // 대문
        int[] arr = new int[26]; // 알파벳 숫자
        int max = -1;
        char result = '?';

				// 아스키 코드값 사용.
				//  C 를 입력받았을 때, 배열의 세 번째 원소인 2 을 도출
				//->  C 는 67 이니 65을 빼면 됨.
				// + 문자가 'A'인 경우, 'A' - 'A'는 0이 되어 배열의 0번 인덱스에 해당하는 위치
				// 'A'의 아스키 코드 값인 65
        for (int i = 0; i < s.length(); i++) {
		        // 현재 문자의 출현 빈도를 1 증가시킵니다.
		        // 'A'의 아스키 코드 값을 빼서 배열의 인덱스로 사용
            arr[s.charAt(i) - 'A']++;
            if (max < arr[s.charAt(i) - 'A']) { // 현재 문자의 출현 빈도가 이전 최대 빈도보다 큰 경우
                max = arr[s.charAt(i) - 'A']; // 현재 문자의 출현 빈도로 업데이트
                result = s.charAt(i); // 현재 문자로 업데이트
            } else if (max == arr[s.charAt(i) - 'A']) {
                result = '?';
            }
        }
        System.out.println(result);
    }
}