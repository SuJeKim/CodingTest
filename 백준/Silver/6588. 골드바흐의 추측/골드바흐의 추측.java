import java.io.*;

public class Main {
    private static boolean[] prime = new boolean[1000000] ;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        // 소수배열 prime. buffer받기전 실행
        getPrime();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // 0이 나올때까지 반복
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            // 추측이 틀렸을 경우 판별하기 위한 변수
            boolean check = false;
            
            // 짝수 n을 두 홀수 소수의 합으로 나타내는지 확인
            // n / 2 반복.
            for (int i = 2; i <= n / 2; i++) {
                // i와(n-i)가 모두 소수인지 확인
                if (!prime[i] && !prime[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    check = true;
                    break;
                }
            }
            if (check == false) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
    // 에라토스테네스의 체 알고리즘
    // true = 소수아님 , false = 소수 
    public static void getPrime() {
        prime[0] = prime[1] = true;
        
        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}