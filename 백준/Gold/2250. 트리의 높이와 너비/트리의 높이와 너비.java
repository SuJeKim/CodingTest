import java.io.*;
import java.util.*;

public class Main {
	
	static class Node{
		int val; // 노드 번호
		Node left, right;
		int parent;// 부모 노드(-1이면 루트)
		
		Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.parent = -1; // 기본값
		}
	}
	
	// n: 노드 수, maxLevel: 최대 트리 깊이
	private static int n, x, maxLevel;
	private static Node root;
	private static StringBuilder sb = new StringBuilder();
	// 노드 리스트
	private static ArrayList<Node> tree = new ArrayList<>();
	// 각 레벨별 최소 x, 최대 x 좌표
	static int[] eachLevelMin, eachLevelMax;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		eachLevelMax = new int[n + 1];
		eachLevelMin = new int[n + 1];
		
		// 트리 초기화
		// 노드 번호, 왼쪽 자식, 오른쪽 자식
		// 노드 번호 일치시키기 위해 <= n
		for(int i = 0; i <= n; i++) {
			// 자식 노드가 존재하지 않으니 null
			// 0 -> 존재하는 것처럼 보임.
			tree.add(new Node(i ,null, null));
			eachLevelMin[i] = n;
		}
		
		// 트리 구성
		for(int i =0; i < n; i++) {
			String s = br.readLine();
			String[] split = s.split(" ");
			int value = Integer.parseInt(split[0]); // 일단 부모 노드 번호
			Node node = tree.get(value);
			
			// 자식 left, right 저장.
			int leftVal = Integer.parseInt(split[1]);
			if(leftVal != -1) {
				tree.get(leftVal).parent = value;
				node.left = tree.get(leftVal);
			}
			
			int rigthVal = Integer.parseInt(split[2]);
			if(rigthVal != -1) {
				tree.get(rigthVal).parent = value;
				node.right = tree.get(rigthVal);
			}
		}
		
		//이제 트리 다 만들어졌으니 root 찾기
		for(Node node : tree) {
			if(node.val != 0) {
				if(node.parent == -1) {
					root = node;
					break;
				}
			}
		}
		
		// 이제 중위 순회하면서 각 레벨의 넓이 구하기
		// 가장 왼쪽 좌표 x = 1;
		x = 1;
		inOrder(root,1);
		
		// 각 레벨의 넓이 구해졌으니 최대 넓이 출력.
		int resultLevel = 0;
		int resultWidth = 0;
		for(int level = 1; level <= maxLevel; level++) {
			int wid = eachLevelMax[level] - eachLevelMin[level] + 1;
			if(resultWidth < wid) {
				resultWidth = wid;
				resultLevel = level;
			}
		}
		sb.append(resultLevel).append(" ").append(resultWidth);
		System.out.println(sb);

	}

	/**
	 * 중위 순회하면서 각 노드에 x 좌표 부여 + 레벨별 min/max값 갱신.
	 * @param nood
	 * @param level
	 */
	private static void inOrder(Node node, int level) {
		if(node == null) return;
		
		// 최대 길이 갱신
		maxLevel = Math.max(level, maxLevel);
		
		// 왼쪽 자식 방문
		if(node.left != null) {
			inOrder(node.left, level + 1);
		}
		
		// 현 노드의 x좌표 설정.
		// 현 노드가 해당 레벨에서 가장 왼쪽에 있는 노드일 경우
		// 기존 x보다 최소값 갱신
		// 레벨마다 왼쪽 끝 노드 x좌표 
		eachLevelMin[level] = Math.min(eachLevelMin[level], x);
		
		// 현재 레벨의 가장 오른쪽 위치 갱신
		// 중위 순회: 왼쪽 -> 오른쪽
		// 항상 증가하므로 최대치 확인 필요 없음.
		eachLevelMax[level] = x;
		
		// 다음 노드 방문 시 증가.
		x++;
		
		// 이제 오른쪽
		if(node.right != null) {
			inOrder(node.right, level + 1);
		}
	}

}
