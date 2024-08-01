import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int n = scanner.nextInt(); // 문자열 집합의 크기
        int m = scanner.nextInt(); // 확인할 문자열의 개수
        scanner.nextLine(); // 개행 문자 처리

        HashSet<String> stringSet = new HashSet<>();

        // 문자열 집합 입력
        for (int i = 0; i < n; i++) {
            stringSet.add(scanner.nextLine());
        }

        // 확인할 문자열 개수
        int count = 0;
        for (int i = 0; i < m; i++) {
            String query = scanner.nextLine();
            if (stringSet.contains(query)) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
