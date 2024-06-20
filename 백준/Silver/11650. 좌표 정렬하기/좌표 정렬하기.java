import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[][] coords = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            coords[i][0] = scanner.nextInt();
            coords[i][1] = scanner.nextInt();
        }
        
        Arrays.sort(coords, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 첫 번째 원소(x)를 기준으로 정렬하고
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                // 첫 번째 원소가 같으면 두 번째 원소(y)를 기준으로 정렬
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        for (int i = 0; i < N; i++) {
            System.out.println(coords[i][0] + " " + coords[i][1]);
        }
        
        scanner.close();
    }
}
