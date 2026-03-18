class Solution {
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int videoLen = toSecond(video_len);
        int current = toSecond(pos);
        int opStart = toSecond(op_start);
        int opEnd = toSecond(op_end);
        
        // 시작 위치가 오프닝 구간이면 먼저 스킵
        current = skipOpening(current, opStart, opEnd);
        
        for (String command : commands) {
            if (command.equals("prev")) {
                current = Math.max(0, current - 10);
            } else if (command.equals("next")) {
                current = Math.min(videoLen, current + 10);
            }
            
            // 이동 후 오프닝 구간이면 스킵
            current = skipOpening(current, opStart, opEnd);
        }
        
        return toTime(current);
    }
    
    // 현재 위치가 오프닝 구간이면 op_end로 이동
    private int skipOpening(int current, int opStart, int opEnd) {
        if (opStart <= current && current <= opEnd) {
            return opEnd;
        }
        return current;
    }
    
    // "mm:ss" -> 초
    private int toSecond(String time) {
        String[] parts = time.split(":");
        int minute = Integer.parseInt(parts[0]);
        int second = Integer.parseInt(parts[1]);
        return minute * 60 + second;
    }
    
    // 초 -> "mm:ss"
    private String toTime(int totalSecond) {
        int minute = totalSecond / 60;
        int second = totalSecond % 60;
        return String.format("%02d:%02d", minute, second);
    }
}