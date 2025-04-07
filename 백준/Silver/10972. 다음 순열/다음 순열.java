import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(permutationCheck(arr)) {
			for(int val : arr) {
				sb.append(val).append(" ");
			}
		}else {
			System.out.println("-1");
		}
		System.out.println(sb);
	}

	private static boolean permutationCheck(int[] arr) {
		int i = arr.length - 1;
		
		// arr[i-1] < arr[i]이 성립하는 부분에서 i가 가장 큰 것
		while(i > 0 && arr[i-1] > arr[i]) {i -= 1;}
		if(i <= 0) return false;
		
		// arr[i-1] 보다는 큰 수이면서 동시에 가장 작은 수(j) 선택.
		int j = arr.length -1;
		while(arr[i-1] > arr[j]) {j -= 1;}
		
		// arr[i-1]과 arr[j] swap
		int temp = arr[j];
		arr[j] = arr[i-1];
		arr[i-1] = temp;
		
		// arr[i]부터 오름차순 정렬
		j = arr.length -1;
		while(i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i += 1;
			j -= 1;
		}
		
		return true;
	}

}
