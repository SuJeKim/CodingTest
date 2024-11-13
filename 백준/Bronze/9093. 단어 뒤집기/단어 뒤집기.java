import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for(int i=0;i<n;i++){
            Stack<Character> box = new Stack<>();
            String word =bf.readLine();
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<word.length();j++){
            	if(word.charAt(j) == ' ') {
            		while(!box.empty()) {
            			sb.append(box.pop());
            		}
            		sb.append(" ");
            	}else {
                    box.push(word.charAt(j));
            	}
            }
    		while(!box.empty()) {
    			sb.append(box.pop());
    		}
    		System.out.println(sb);
        }
    }
}