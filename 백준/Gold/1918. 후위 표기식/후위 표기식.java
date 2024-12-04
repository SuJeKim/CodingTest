import java.util.*;
 
public class Main {    
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        char[] line = scan.nextLine().toCharArray();
        
        // 연산자를 담을 스택
        Stack<Character> op = new Stack<>(); 
        //정답 출력
        StringBuilder sb = new StringBuilder();
        
        /*
        * 1. 연산식이 숫자라면 그대로 문자열에 담아준다.
        * 2. 연산식이 숫자가 아니라면
        *     '(' => 일단 push
        *     ')' => '('이 나올때까지 pop 및 sb.append
        *         => 그 후 '('연산자 pop
        * 3. + - / * 연산자 일경우
        *    => 우선순위 메서드 priority에 따라 높거나 같으면 pop 및 sb.append
        *     
        */
        for(int i = 0; i < line.length; i++) {
            if(line[i] >= 'A' && line[i] <= 'Z') sb.append(line[i] + "");
            else { 
                if(line[i] == '(') op.push(line[i]);
                else if(line[i] == ')') { 
                    while(!op.isEmpty() && op.peek() != '(') {
                        sb.append(op.pop()); 
                    }
                    if(!op.isEmpty()) op.pop(); 
                }
                else { 
                    while(!op.isEmpty() && priority(op.peek()) >= priority(line[i])) {
                        sb.append(op.pop());
                    }
                    op.push(line[i]);
                }
            }
        }
        //스택에 있는 남은 연산자를 모두 꺼낸다.
        while(!op.isEmpty()) {
            sb.append(op.pop());
        }
        System.out.println(sb);
    }
   
    /* 우선순위 메서드
    * *, / ⇒ 우선순위가 가장 높으므로 2로 설정.
    * +, -, ⇒ 중간 단계 1로 설정.
    * (’ => 0
    */
    public static int priority(char op) {
        if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;
        else return 0; 
    }
}
