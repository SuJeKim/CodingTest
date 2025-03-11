import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		char[][] arr = new char[n][n];
		for(int i = 0; i< n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int maxValue = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				// 오른쪽과 교환
				if(j < n-1) {
					swap(arr,i,j,i,j+1);
					maxValue = Math.max(maxValue, calculateMaxValue(arr,n));
					swap(arr,i,j,i,j+1);
				}
				// 아래쪽과 교환
				if(i < n-1) {
					swap(arr, i, j, i+1, j);
					maxValue = Math.max(maxValue, calculateMaxValue(arr,n));
					swap(arr, i, j, i+1, j);
				}
			}
		}
		System.out.println(maxValue);

	}
	// 동일한 사탕 갯수의 최댓값 찾기
	private static int calculateMaxValue(char[][] arr, int n) {
		int maxLen = 0;
		
		for(int i = 0; i < n; i++) {
			
			// 현재 검사 중인 행, 열에서 사탕 수 셀 변수
			int countRow = 1;
			int countCol = 1;
			
			for(int j = 1; j < n; j++) {
				
				// 행 검사
				if(arr[i][j] == arr[i][j-1]) {
					countRow++;
				}else {
					maxLen = Math.max(maxLen, countRow);
					countRow = 1;
				}
				
				// 열 검사
				if(arr[j][i] == arr[j-1][i]) {
					countCol++;
				}else {
					maxLen = Math.max(maxLen, countCol);
					countCol = 1;
				}
			}
			maxLen = Math.max(maxLen, countRow);
			maxLen = Math.max(maxLen, countCol);
		}
		return maxLen;
	}

	// (x1, y1), (x2,y2) 위치 변경
	private static void swap(char[][] arr, int x1, int y1, int x2, int y2) {
		char temp = arr[x1][y1];
		arr[x1][y1] = arr[x2][y2];
		arr[x2][y2] = temp; 
		
	}

}
