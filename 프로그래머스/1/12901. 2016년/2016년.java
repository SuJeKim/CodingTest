class Solution {
    public String solution(int a, int b) {
        // 2016년 각 달의 일수
        int[] monthdays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 1월 1일이 금요일.
        String[] week = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
    
        int totalDays = 0;
        
        // 1. a월 이전까지의 일수를 모두 더함
        for (int i = 0; i < a - 1; i++) {
            totalDays += monthdays[i];
        }
        
        // 2. 해당 월의 일수(b)를 더함
        // 1월 1일부터 시작하므로 당일을 제외한 경과일을 구하기 위해 b-1을 더함
        totalDays += (b - 1);
        
        // 3. 총 일수를 7로 나눈 나머지를 인덱스로 사용
        return week[totalDays % 7];
    
    }
}