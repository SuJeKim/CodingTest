import java.io.*;
import java.util.*;

public class Main {
    static int N; // 역의 수
    static ArrayList<Integer>[] graph; // 인접 리스트 그래프
    static boolean[] visited; // DFS 방문 여부
    static boolean[] isCycle; // 순환선(사이클) 포함 여부
    static int[] distance; // 각 역에서 사이클까지 최단 거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 배열 초기화
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        isCycle = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // 사이클 탐색 시작
        for (int i = 1; i <= N; i++) {
        	// 각 시작점마다 visited 초기화
            Arrays.fill(visited, false); 
            if (dfs(i, -1, i)) break;
        }

        // 사이클로부터 거리 계산
        bfs();

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= N; i++) {
            bw.write(distance[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    // 사이클을 찾는 DFS (시작, 이전 노드, 현재 노드)
    static boolean dfs(int start, int prev, int cur) {
        visited[cur] = true;
        //System.out.println("DFS 방문: " + prev + " -> " + cur); 
        
        for (int next : graph[cur]) {
            if (!visited[next]) {
                if (dfs(start, cur, next)) {
                    if (!isCycle[cur]) {
                    	isCycle[cur] = true; // 사이클 경로에 포함되면 마킹
                    	//System.out.println("사이클 경로 포함: " + cur);
                    }
                    return true;
                }
            } else if (next != prev && next == start) {
                // 현재 노드에서 시작점으로 돌아가면 → 사이클
                isCycle[cur] = true;
                return true;
            }
        }

        return isCycle[cur];
    }

    // 사이클에서부터의 최단 거리 계산 
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        
     // 거리 배열 초기화 미방문
        Arrays.fill(distance, -1);

        // 사이클에 포함된 노드를 시작점으로 BFS 수행
        for (int i = 1; i <= N; i++) {
            if (isCycle[i]) { // 사이클에 표함됨 -> 거리 0
                distance[i] = 0;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}

