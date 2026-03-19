import java.util.*;

class Solution {
    static int n, k;
    static List<Integer>[][] graph;   // [type][node]
    static BitSet[][] comp;           // [type][node] : same-component nodes
    static int answer;

    public int solution(int n, int infection, int[][] edges, int k) {
        Solution.n = n;
        Solution.k = k;
        answer = 1;

        // 타입 1~3, 노드 1~n
        graph = new ArrayList[4][n + 1];
        for (int t = 1; t <= 3; t++) {
            for (int i = 1; i <= n; i++) {
                graph[t][i] = new ArrayList<>();
            }
        }

        // 타입별 그래프 구성
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int type = e[2];
            graph[type][x].add(y);
            graph[type][y].add(x);
        }

        // 같은 타입 그래프에서의 연결 컴포넌트 미리 계산
        comp = new BitSet[4][n + 1];
        buildComponents();

        // 초기 감염 상태
        BitSet infected = new BitSet(n + 1);
        infected.set(infection);

        // 길이 0도 가능 (아무것도 안 열기)
        answer = Math.max(answer, infected.cardinality());

        // 가능한 순서 전부 탐색
        dfs(0, 0, infected);

        return answer;
    }

    // 모든 타입 순서 탐색
    static void dfs(int depth, int prevType, BitSet infected) {
        answer = Math.max(answer, infected.cardinality());

        if (depth == k) return;

        for (int type = 1; type <= 3; type++) {
            if (type == prevType) continue; // 같은 타입 연속 사용 무의미

            BitSet next = spread(infected, type);
            dfs(depth + 1, type, next);
        }
    }

    // type 파이프를 한 번 열었을 때 감염 확산
    static BitSet spread(BitSet infected, int type) {
        BitSet next = (BitSet) infected.clone();

        for (int node = infected.nextSetBit(1); node != -1; node = infected.nextSetBit(node + 1)) {
            next.or(comp[type][node]);
        }

        return next;
    }

    // 타입별 연결 컴포넌트 계산
    static void buildComponents() {
        for (int type = 1; type <= 3; type++) {
            boolean[] visited = new boolean[n + 1];

            for (int start = 1; start <= n; start++) {
                if (visited[start]) continue;

                List<Integer> componentNodes = new ArrayList<>();
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(start);
                visited[start] = true;

                while (!q.isEmpty()) {
                    int cur = q.poll();
                    componentNodes.add(cur);

                    for (int next : graph[type][cur]) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }
                }

                BitSet bs = new BitSet(n + 1);
                for (int node : componentNodes) {
                    bs.set(node);
                }

                for (int node : componentNodes) {
                    comp[type][node] = (BitSet) bs.clone();
                }
            }
        }
    }
}