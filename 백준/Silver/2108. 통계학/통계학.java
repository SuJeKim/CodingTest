import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 정수 N을 입력 받음
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];

        // N개의 정수를 입력 받아 배열 data에 저장
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        // 산술평균 계산
        double sum = 0;
        for (int num : data) {
            sum += num;
        }
        int mean = (int) Math.round(sum / N);

        // 배열을 오름차순으로 정렬
        Arrays.sort(data);

        // 중앙값 계산
        int median = data[N / 2];

        // 최빈값 계산
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : data) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // 최빈값 찾기
        int maxFreq = Collections.max(count.values());
        List<Integer> numbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == maxFreq) {
                numbers.add(entry.getKey());
            }
        }

        // 최빈값 결정
        int mode;
        if (numbers.size() == 1) {
            // 최빈값이 하나인 경우 그 값을 출력
            mode = numbers.get(0);
        } else {
            // 최빈값이 여러 개인 경우 두 번째로 작은 값을 출력
            Collections.sort(numbers);
            mode = numbers.get(1);
        }

        // 범위 계산
        int range = data[N - 1] - data[0];

        // 결과 출력
        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}
