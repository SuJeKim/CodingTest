import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt() + 5;
        int d = sc.nextInt();
        int num = 0;
        int time = d;

        for (int i = 0; i < n; i++) {
            num += l;
            while (true) {
                if (time < num - 5) {
                    time += d;
                } else {
                    break;
                }
            }
            if (num - 5 <= time && time < num) {
                break;
            }
        }
        System.out.println(time);
    }
}
