import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String line = br.readLine();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            
            //숫자일 경우 그대로 출력
            if (!Character.isLetter(c)) {
                sb.append(c);
                continue;
            }
            //ROT13을 구하기 위해서 캐스팅 후 +13
            int rot = (int)c + 13;
            
            //대문자일 때 Z의 90보다 크면 26 빼기
            if (Character.isUpperCase(c) && rot > 90) {
                rot -= 26;
            }
            
            //소문자일 때 z의 122보다 크면 26 빼기
            if (Character.isLowerCase(c) && rot > 122) {
                rot -= 26;
            }
            sb.append((char)rot);
        }
        System.out.print(sb);
    }
}