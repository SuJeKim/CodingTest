import java.util.*; 
import java.util.Comparator; 

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        
        int N = scanner.nextInt(); 
        
        // 좌표를 저장할 2차원 배열을 생성
        int[][] coords = new int[N][2]; 
        
        // 각 좌표를 입력받아 2차원 배열에 저장
        for (int i = 0; i < N; i++) {
            coords[i][0] = scanner.nextInt(); // x 좌표.
            coords[i][1] = scanner.nextInt(); // y 좌표.
        }
        
        // 2차원 배열을 정렬
        Arrays.sort(coords, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 첫 번째 원소(x)를 기준으로 정렬합니다.
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                // 첫 번째 원소가 같으면 두 번째 원소(y)를 기준으로 정렬합니다.
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        // 정렬된 좌표를 출력
        for (int i = 0; i < N; i++) {
            System.out.println(coords[i][0] + " " + coords[i][1]);
        }
        
        scanner.close(); 
    }
}
