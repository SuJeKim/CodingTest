import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        // 입력어
		String str = br.readLine();
        // 명령어 갯수
		int N = Integer.parseInt(br.readLine());

        // 입력받을 스택.
		Stack<String> LeftStack = new Stack<String>();
        // 커서 변경시 요소 추가 스택.
		Stack<String> RightStack = new Stack<String>();
        
		//처음 커서는 문장의 맨 뒤에서 시작하기 때문에 
        //왼쪽 스택에 초기 입력 문자를 모두 넣어줌 (ex. abc|)
		String[] arr = str.split("");
		for(String s : arr) { 
			LeftStack.push(s); 
		}
		
		for(int i = 0; i < N; i++) {
			String command = br.readLine();
			char c = command.charAt(0);
			
			switch(c) {
			case 'L':
				if(!LeftStack.isEmpty())
					RightStack.push(LeftStack.pop());

				break;
			case 'D':
				if(!RightStack.isEmpty())
					LeftStack.push(RightStack.pop());

				break;
			case 'B':
				if(!LeftStack.isEmpty()) {
					LeftStack.pop();
				}
				break;
			case 'P':
				char t = command.charAt(2); // 공백 있어서 2
				LeftStack.push(String.valueOf(t));

				break;
			default:
				break;
			}
		}
        
		//Stack은 LIFO 구조이기 때문에
		//왼쪽 스택에 있는 데이터들을 모두 오른쪽으로 옮긴 뒤에 오른쪽에 있는 모든 내용을 출력한다.
		while(!LeftStack.isEmpty())
			RightStack.push(LeftStack.pop());
		
		while(!RightStack.isEmpty())
			bw.write(RightStack.pop());
		
		bw.flush();
		bw.close(); 
	}
}