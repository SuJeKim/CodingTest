import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	
	public static void main(String[] args) throws  IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		if(previousSequence(arr)) {
			for(int val : arr) {
				sb.append(val).append(" ");
			}
		}else {
			System.out.println("-1");
		}
		System.out.println(sb);
	}

	private static boolean previousSequence(int[] arr) {
		int i = arr.length -1;
		
		// 1. 뒤에서 부터 오름차순(arr[i-1] < arr[i])인지 확인.
		while(i > 0 && arr[i-1] < arr[i]) {i -= 1;} 
		if(i <= 0) {
			return false;
		}
		
		// 2.  arr[i-1] 보다는 오른쪽에 위치하면서 작은 수이어야 함.
		int j = arr.length - 1;
		while(arr[i-1] < arr[j]) {j -= 1;}
		
		// arr[i-1]과 j를 교환(swap)
		swap(i-1, j);
		
		// 4. arr[i] ~ arr[j] 오름차순 정렬
		j = arr.length - 1;
		while(i < j) {
			swap(i,j);
			i++;
			j--;
		}
		
		return true;
	}

	private static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
	}

}
