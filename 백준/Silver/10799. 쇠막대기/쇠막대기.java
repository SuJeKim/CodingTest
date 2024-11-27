import java.io.*;
import java.util.Stack;
 
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력값 괄호
        String line = bf.readLine();
        Stack<Character> stack = new Stack<>();
 
        // 최종 잘려진 조각 갯수.
        int result = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') { 
                stack.push('(');
                continue;
            }
            if (line.charAt(i) == ')') { 
                
                // 일단 stack에서 pop을 실행.
                stack.pop(); 
 
                // 레이저 일 경우 += stack.size()
                if (line.charAt(i - 1) == '(') { 
                    result += stack.size(); 
                } else {
                    result++; 
                }
            }
        }
 
        bw.write(result + "\n");
        bw.flush();
        bf.close();
        bw.close();
    }
 
}
 