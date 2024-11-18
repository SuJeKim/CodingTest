import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		Stack<Character> stack = new Stack<>();
        
        /*
        * result == 결과
        * value == 값 할당 변수
        */
		boolean flag = true; 
		int result = 0;
		int value = 1;
		for(int i=0; i<line.length(); i++) {
			char ch = line.charAt(i);
			if(ch == '(') {
				stack.push(ch);
				value *= 2;
			}
			else if(ch == '[') {
				stack.push(ch);
				value *= 3;
			}
			else if(ch == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						result = 0;
						break;
					}
                    // 바로 이전 값이 ‘(’ 확인.
					if(line.charAt(i-1) =='(') {
						result += value;
					}
					stack.pop();
                    value /= 2;
				}
            else if(ch==']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                // 바로 이전 값이 ‘[’ 확인.
                if(line.charAt(i-1)=='[') {
                    result += value;
                }
                stack.pop();
                 value /= 3;
            }
		}
		if(!stack.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(result);
		}
	}
}