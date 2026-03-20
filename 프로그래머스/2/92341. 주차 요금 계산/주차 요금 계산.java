import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> totalMap = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            int time = toMinutes(parts[0]);
            String car = parts[1];
            String type = parts[2];

            if (type.equals("IN")) {
                inMap.put(car, time);
            } else {
                int inTime = inMap.remove(car);
                totalMap.put(car, totalMap.getOrDefault(car, 0) + (time - inTime));
            }
        }

        // 출차 안 한 차량 처리 (23:59)
        int endTime = toMinutes("23:59");
        for (String car : inMap.keySet()) {
            int inTime = inMap.get(car);
            totalMap.put(car, totalMap.getOrDefault(car, 0) + (endTime - inTime));
        }

        // 차량 번호 정렬
        List<String> cars = new ArrayList<>(totalMap.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];
        int idx = 0;

        for (String car : cars) {
            int time = totalMap.get(car);
            answer[idx++] = calcFee(time, fees);
        }

        return answer;
    }

    private int toMinutes(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    private int calcFee(int time, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (time <= baseTime) return baseFee;

        int extra = time - baseTime;
        int units = (int) Math.ceil((double) extra / unitTime);

        return baseFee + units * unitFee;
    }
}