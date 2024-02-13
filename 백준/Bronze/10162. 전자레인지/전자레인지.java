import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, a, b, c;
        t = sc.nextInt();

        if (t % 10 != 0) {
            System.out.println("-1");
        } else {
            a = t / 300;
            t = t % 300;
            b = t / 60;
            t = t % 60;
            c = t / 10;

            System.out.println(a + " " + b + " " + c);
        }
    }
}
