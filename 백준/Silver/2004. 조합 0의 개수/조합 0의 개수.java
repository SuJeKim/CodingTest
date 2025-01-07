import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		// 각 순서쌍(2 * 5)의 cnt를 구한다.
		long Cnt2 = twoPower(N)- twoPower(N - M)- twoPower(M);
		long Cnt5 = fivePower(N)- fivePower(N - M)- fivePower(M);
		//System.out.println("2의 개수: " + Cnt2);
		//System.out.println("5의 개수: " + Cnt5);
		
		
		System.out.println(Math.min(Cnt2, Cnt5));
	}

	// 5의 인수 개수 구하는 함수
	private static int fivePower(long n) {
		int cnt = 0;
		
		while(n >= 5) {
			cnt += (n / 5);
			n /= 5;
		}
		return cnt;
	}

	// 2의 인수 개수 구하는 함수
	private static long twoPower(long n) {
		int cnt = 0;
		
		while(n >= 2) {
			cnt += (n / 2);
			n /= 2;
		}
		return cnt;
	}

}
