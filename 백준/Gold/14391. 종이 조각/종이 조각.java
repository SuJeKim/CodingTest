import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[][] arr;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				// 아스키코드 사용해서 변환
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		// 2^(n * M)만큼 경우의 수 탐색. 
		// 가로(0) / 세로(1) 결정
		for(int bit = 0; bit < (1 << (n * m)); bit++) {
			max = Math.max(max,search(bit));
		}
		System.out.println(max);
		
	}

	/**
	 *  가로(0) / 세로(1) 설정 된 값의 총합 계산
	 * @param bit 각 캄의 가로/ 세로 여부 확인
	 * @return 총합 리턴.
	 */
	private static int search(int bit) {
		int sum = 0;
		
		// 가로(0) (행 기준으로 열 확인 계산 
		for(int i = 0; i < n; i++) {
			// 현재 가로 조각 숫자
			int row = 0;
			for(int j = 0; j < m; j++) {
				
				//2차원 인덱스 → 1차원 인덱스로 변환
				int idx = i * m + j;
				
				if((bit & (1 << idx)) == 0) {
					// 현재 숫자에 이어붙이기
					row = row * 10 + arr[i][j];
					//System.out.println("가로 숫자: " + row);
				} else {
					// 가로 조각이 끝나면 지금까지 숫자 더하고 초기화
					sum += row;
					row = 0;					
				}
			}
			// 마지막 칸이 가로일 수도 있으니 한 번 더 합.
			sum += row;
			//System.out.println("최종 가로 숫자: " + sum);
		}
		
		// 세로(1) (열 기준으로 행 확인 계산 
		for(int i = 0; i < m; i++) {
			// 현재 세로 조각 숫자
			int col = 0;
			for(int j = 0; j < n; j++) {
				
				//2차원 인덱스 → 1차원 인덱스로 변환
				int idx = j * m + i;
				
				if((bit & (1 << idx)) != 0) {
					// 현재 숫자에 이어붙이기
					col = col * 10 + arr[j][i];
					//System.out.println("가로 숫자: " + col);
				} else {
					// 세로 조각이 끝나면 지금까지 숫자 더하고 초기화
					sum += col;
					col = 0;					
				}
			}
			// 마지막 칸이세로일 수도 있으니 한 번 더 합.
			sum += col;
			//System.out.println("최종 세로 숫자: " + sum);
		}
		
		
		return sum;
	}

}
