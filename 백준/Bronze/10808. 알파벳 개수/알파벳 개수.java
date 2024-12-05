import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //알파벳 개수를 저장하는 배열
        int[] answer = new int[26];  
        // 입력받기
        String line = br.readLine();  
        for (int i = 0; i < line.length(); i++) {
            //각 해당 i(알파벳) 개수 1씩 늘려주기
            answer[line.charAt(i) - 97]++;  
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}