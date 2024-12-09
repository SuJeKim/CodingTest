import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            //소문자 
            int small = 0; 
            //대문자 
            int capital = 0;  
            //숫자
            int number = 0; 
            //공백
            int space = 0;  
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == ' ') space++;
                if (Character.isUpperCase(c)) capital++;
                if (Character.isLowerCase(c)) small++;
                if (Character.isDigit(c)) number++;
            }
            sb.append(small + " " + capital + " " + number + " " + space + "\n");
        }
        System.out.print(sb);
    }
}