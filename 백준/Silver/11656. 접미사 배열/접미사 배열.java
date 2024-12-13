import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        // 입력받은 문자열의 길이만큼 array 배열 선언.
        String[] array = new String[line.length()];

        for(int i = 0; i < line.length(); i++) {
            array[i] = line.substring(i, line.length());
        }

        Arrays.sort(array);

        for(String str : array) {
            System.out.println(str);
        }

    }
}