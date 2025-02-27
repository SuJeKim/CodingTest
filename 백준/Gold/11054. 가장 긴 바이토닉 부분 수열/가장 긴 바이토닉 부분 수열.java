import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] arr;
	static int[] increasingDp;
	static int[] decreasingDp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		increasingDp = new int[n];
		decreasingDp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		increasing();
		decreasing();
		
		int maxNum = 0;
		for(int i = 0; i<n; i++) {
			//System.out.println("증가 수열: " + increasingDp[i]);
			//System.out.println("감소 수열: " + decreasingDp[i]);
			maxNum = Math.max(maxNum ,increasingDp[i] + decreasingDp[i]);
			//System.out.println(maxNum);
		}
		System.out.println(maxNum -1);
		
		
		
		

	}

	// 감소 부분 배열 decreasingDp
	private static void decreasing() {
		for(int i = n-1; i >= 0; i--) {
			decreasingDp[i] = 1;
			for(int j = n-1; j > i; j--) {
				if(arr[j] < arr[i] && decreasingDp[i] < decreasingDp[j] + 1) {
					decreasingDp[i] = decreasingDp[j] + 1;
				}
			}
		}
		
	}

	// 증가 부분 배열 increasingDp
	private static void increasing() {
		for(int i = 0; i < n; i++) {
			increasingDp[i] = 1;
			for(int j = 0; j< i; j++) {
				if(arr[j] < arr[i] && increasingDp[i] < increasingDp[j] + 1) {
					increasingDp[i] = increasingDp[j] + 1;
				}
			}
		}
		
	}

}
