import java.io.*;
import java.util.Stack;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			sb.append(solve(br.readLine())).append('\n');
		}
		
		System.out.println(sb);
	}
 
	public static String solve(String s) {
 
		Stack<Character> stack = new Stack<>();
 
		for (int i = 0; i < s.length(); i++) {
 
			char c = s.charAt(i);
 
			// 여는 괄호일 경우 스택에 넣는다.
			if (c == '(') {
				stack.push(c);
			}
 
            // 여기부턴 닫는 괄호.
			// 닫는 괄호를 입력받았으나 pop할 원소가 없을 경우
			else if (stack.empty()) {
				return "NO";
			}
			// 그 외의 경우 stack 원소를 pop 한다.
			else {
				stack.pop();
			}
		}
 
		/*
		 * 문자열이 끝난 후 스택 확인 
     * ( -> NO, 비어있음 -> YES
		 */
 
		if (stack.empty()) {
			return "YES";
		} 
		else {
			return "NO";
		}
	}
}