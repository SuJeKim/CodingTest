import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        
        // '-'를 기준으로 수식을 분할합니다.
        String[] parts = expression.split("-");
        
        // 첫 번째 부분은 무조건 더합니다.
        int initialSum = sumOfParts(parts[0]);
        
        // 나머지 부분은 모두 빼줍니다.
        for (int i = 1; i < parts.length; i++) {
            initialSum -= sumOfParts(parts[i]);
        }
        
        System.out.println(initialSum);
    }
    
    private static int sumOfParts(String part) {
        String[] additionParts = part.split("\\+");
        int sum = 0;
        for (String additionPart : additionParts) {
            sum += Integer.parseInt(additionPart);
        }
        return sum;
    }
}
