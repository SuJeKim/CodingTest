import java.util.*;

class Solution {
    
    static class Job implements Comparable<Job> {
        int requestTime, workingTime;
        
        public Job(int requestTime, int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }
        
        @Override
        public int compareTo(Job j) {
            if (this.requestTime == j.requestTime) {
                return this.workingTime - j.workingTime;
            }
            return this.requestTime - j.requestTime;
        }
    }
    
    public int solution(int[][] jobs) {
        PriorityQueue<Job> disk = new PriorityQueue<>();
        int len = jobs.length;
        
        for(int[] job: jobs) {
            disk.add(new Job(job[0], job[1]));
        }
        
        int time = 0; // 현재 시간
        int ans = 0; // 처리량 평균 구하기
        List<Job> execList = new ArrayList<>();
        
        while (!disk.isEmpty() || !execList.isEmpty()) {
            // 현재 시간에 요청된 작업을 모두 execList에 추가
            while (!disk.isEmpty() && time >= disk.peek().requestTime) {
                execList.add(disk.poll());
            }

            // 작업을 소요 시간 기준으로 정렬
            if (!execList.isEmpty()) {
                Collections.sort(execList, Comparator.comparingInt(job -> job.workingTime));
                Job exec = execList.remove(0);
                if (time < exec.requestTime) {
                    time = exec.requestTime;
                }
                time += exec.workingTime;
                ans += time - exec.requestTime;
            } else if (!disk.isEmpty()) {
                time = disk.peek().requestTime;
            }
        }
        
        return ans / len;
    }
}