import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();

        // tag 확인 
        boolean check = false;

        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '<'){
                check = true;
                while(!stack.empty()){
                    sb.append(stack.pop());
                }
                sb.append(line.charAt(i));
            }

            else if(line.charAt(i) == '>'){
                check = false;
                sb.append(line.charAt(i));
            }

            else if(check){
                sb.append(line.charAt(i));
            }

            else if(!check){
                if(line.charAt(i) == ' '){
                    while(!stack.empty()){
                        sb.append(stack.pop());
                    }
                    sb.append(line.charAt(i));
                }

                else {
                    stack.push(line.charAt(i));
                }
            }
        }

        while(!stack.empty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }

}