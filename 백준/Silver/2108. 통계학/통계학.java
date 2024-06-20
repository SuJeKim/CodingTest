import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 배열 정렬
        Arrays.sort(arr);

        // 산술평균 계산
        double sum = 0;
        for (int num : arr) {
            sum += num;
        }
        int mean = (int)Math.round(sum / N);

        // 중앙값 계산
        int median = arr[N / 2];

        // 최빈값 계산
        int count = 0;
        int max = -1;
        int mod = arr[0];
        boolean check = false;

        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                count = 0;
            }

            if (max < count) {
                max = count;
                mod = arr[i];
                check = true;
            } else if (max == count && check) {
                mod = arr[i];
                check = false;
            }
        }

        // 범위 계산
        int range = arr[N - 1] - arr[0];

        // 결과 출력
        System.out.println(mean);
        System.out.println(median);
        System.out.println(mod);
        System.out.println(range);
    }
}
