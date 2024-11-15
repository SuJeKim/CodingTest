import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	
		
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int start = 1;
		
		// N 번 반복
		while(N -- > 0) {
			
			int value = Integer.parseInt(br.readLine());
			
			if(value >= start) {
				//입력받은 value 까지 push
				for(int i = start; i <= value; i++) {
					stack.push(i);
					sb.append('+').append('\n');	
				}
				// stack에 4까지 존재했으니까 그 다음 수 5부터 채워야 함.
				start = value + 1;
			}
			
			// value != stack의 top 
			else if(stack.peek() != value) {
				System.out.println("NO");
				return;	
			}
			
			stack.pop();
			sb.append('-').append('\n');
			
		}
		
		System.out.println(sb);
	}
}