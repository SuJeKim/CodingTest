import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t --> 0) {
			long result = 0;
			
			// 입력 string[] => int[]
			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int[] arr = new int[n];
			
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(line[i+1]);
			}
			
			// 쌍 배정
			for(int i = 0; i < arr.length-1; i++) {
				for(int j = i + 1; j < arr.length; j++) {
					// 최대공약수 함수 호출 및 합
					result += getGcd(arr[i],arr[j]);
					//System.out.println("확인 :" + result);
				}
			}
			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
		
	}

	// 최대공약수 함수.
	private static long getGcd(int a, int b) {
		//System.out.println("함수 확인: a="+ a + "b=" + b);
		
		if(a % b == 0) return b;
		
		return getGcd(b, a % b);
	}

}
