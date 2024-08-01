import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 회의 수 입력
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];

        // 회의 시작 시간과 종료 시간 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        // 종료 시간 기준으로 정렬 (끝나는 시간, 시작 시간 순)
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });

        // 회의 수 세기
        int count = 0;
        int lastEndTime = 0;

        // 회의 선택
        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= lastEndTime) { // 현재 회의의 시작 시간이 마지막 선택한 회의의 종료 시간과 같거나 클 경우
                count++;
                lastEndTime = meetings[i][1]; // 마지막 선택한 회의의 종료 시간을 업데이트
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
