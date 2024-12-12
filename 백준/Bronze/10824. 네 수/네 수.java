import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String ab = st.nextToken() + st.nextToken();
        String cd = st.nextToken() + st.nextToken();
        long first = Long.parseLong(ab);
        long second = Long.parseLong(cd);
        System.out.println(first + second);
    }
}