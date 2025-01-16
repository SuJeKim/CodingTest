import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static boolean[] prime = new boolean[1000000];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// true = 소수 아님, false = 소수
		getPrime();
		int t = Integer.parseInt(br.readLine());
		while(t --> 0) {
			int num = Integer.parseInt(br.readLine());
			
			// 결과 값
			int count = 0;
			
			// 판별
			// 순서만 다르고 두 소수가 같은 경우는 같은 파티션임으로 N/2한다.
			for(int i = 2; i <= num/2; i++) {
				// 모두 소수인지 확인
				if(!prime[i] && !prime[num-i]) {
					//System.out.println(i+ "," + (num-i));
					count++;
				}
			}
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
		

	}


	/**
 	소수 판정(에라토스테네스의 체)
	true = 소수 아님, false = 소수
	1,2 => 소수 아님.
	 */
	private static void getPrime() {
		prime[0] = prime[1] = true;
		
		for(int i = 2; i < Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j<prime.length; j+=i) {
				prime[j] = true;
			}
		}
		
	}

}
