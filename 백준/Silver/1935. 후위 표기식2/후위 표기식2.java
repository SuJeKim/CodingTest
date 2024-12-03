import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[] line = br.readLine().toCharArray();
        
        Stack<Double> stack = new Stack();
        
        // 연산자.
        String pattern = "+,*,/,-";
        
        double result = 0;

        // 피연산자(숫자), 출력이 Double => Double 선언.
        Double[] arr = new Double[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        
        // 피연산자, 연산자 분리
        for (int i=0; i<line.length; i++) {
            String chracter = Character.toString(line[i]);
            // 피연산자면 stack에 push
            if ( !pattern.contains(chracter) ) {        
                stack.push(arr[line[i] - 'A']);
            } 
            // 연산자면 stack에서 2개 꺼내서 연산
            else {                                    
                double num2 = stack.pop();
                double num1 = stack.pop();

                result = getCalculate(chracter, num1, num2, result);
                stack.push(result);
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));
    }
    
    /* 연산자 계산 메서드
    * String operator: 연산자
    * num1, num2: 계산할 값들.
    * result: 연산 수행 후 다시 스택에 집어넣기 위해 존재.
    */
    static double getCalculate(String operator, double num1, double num2, double result) {
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "-":
                result = num1 - num2;
                break;
        }
        return result;
    }
}