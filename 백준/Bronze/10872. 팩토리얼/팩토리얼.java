import java.io.*;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = factorial(N);
		System.out.println(result);
		
	}
	
	public static int factorial(int N) {
        // 종료
		if(N <= 1) return 1;	
		// 재귀호출
        return N * factorial(N - 1);		
	}
 
}