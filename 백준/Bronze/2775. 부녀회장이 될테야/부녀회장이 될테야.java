import java.util.Scanner;

public class Main {
    public static int countPeople(int k, int n) {
        // 기저 사례: 0층일 때
        if (k == 0) return n;
        // 기저 사례: 1호일 때
        if (n == 1) return 1;
        // 재귀 호출
        return countPeople(k-1, n) + countPeople(k, n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스(T) 입력
        for (int i = 0; i < T; i++) {
            int k = sc.nextInt();  // 층
            int n = sc.nextInt();  // 호
            System.out.println(countPeople(k, n));
        }
        sc.close();
    }
}
