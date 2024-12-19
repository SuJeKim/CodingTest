import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 개수
        int t = sc.nextInt(); 

        while (t-- > 0) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            int mul = findLCM(num1, num2);
            System.out.println(mul);
        }

        sc.close();
    }

     // 최소공배수 함수
    public static int findLCM(int num1, int num2) {
        int max = Math.max(num1, num2);
        int mul = max; 
        
        while (true) {
            // 최소공배수 조건식
            if (mul % num1 == 0 && mul % num2 == 0) {
                break; 
            }
            mul += max;
        }

        return mul;
    }
}