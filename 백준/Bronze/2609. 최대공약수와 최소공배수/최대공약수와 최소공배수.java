import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
    
        // 최대공약수.
        int gcd = getGCD(num1, num2); 
    
        // 최소공배수 =  (A * B) / gcd
        System.out.println(gcd);
        System.out.println(((num1*num2)/gcd));
        
    }

	//최대공약수 재귀 메서드
    private static int getGCD(int num1, int num2) {
       
        // 나머지가 0이면 return
        if (num1%num2 == 0) return num2;

		// 아닐 경우 다시 나눔
        return getGCD(num2, num1%num2);
    }
    
}