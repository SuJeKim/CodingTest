import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 트럭의 수
        int n = Integer.parseInt(st.nextToken());
        // 다리 길이
        int w = Integer.parseInt(st.nextToken());
        // 최대 하중
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        
        // 시간.
        int time = 0;
        // 현 다리 위 하중.
        int bridgeWeight = 0;
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken())); 
        }

        // 현재 다리에 올라와있는 트럭의 무게
        for (int i = 0; i < w; i++) {
            bridge.add(0); 
        }

        /*
        * 현재 다리에 올라와 있는 트럭이 존재하지 않을 때 까지
        * 시간이 1씩 증가
        * 트럭큐에 담긴 맨앞의 값과 현재 다리위에 올라와있는 
        * 트럭의 무게의 합이 L 보다 낮을때
        *     다리에 한 대 씩 올라감
        *     else truck.poll()은 하지 않는다.
        */
        while (!bridge.isEmpty()) { 
            time++; 
            bridgeWeight-=bridge.poll(); 
            if (!truck.isEmpty()) { 
                if (truck.peek() + bridgeWeight <= L) { 
                    bridgeWeight += truck.peek();
                    bridge.add(truck.poll()); 
                } else {
                    bridge.add(0); 
                }
            }
        }
        System.out.println(time);

    }
}