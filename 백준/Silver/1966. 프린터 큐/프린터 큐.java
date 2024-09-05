import java.io.*;
import java.util.*;

public class Main {

    static LinkedList<int[]> queue; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
			// 테스트케이스의 개수
        int T = Integer.parseInt(br.readLine()); 
				
				//테스트케이스의 개수만큼 반복
        while(T --> 0){ 
			      //테스트케이스만큼 큐 존재 -> 반복문 돌때마다 초기화
            queue = new LinkedList<>(); 

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); //문서의 개수
            int M = Integer.parseInt(st.nextToken()); //몇번째로 인쇄되는지 알고 싶은 문서의 순서 번호

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){ //문서의 개수만큼 입력받아야 하므로 N번 반복
			           //각각의 초기 위치, 중요도를 입력한다.
                queue.add(new int[]{i, Integer.parseInt(st.nextToken())}); 
            }
						
						// 각 테스트 케이스 결과 sb에 주가(줄 바꿈 가티)
            sb.append(find(M)).append("\n");
        }
        br.close();
        
        // 한번에 결과 출력
        System.out.println(sb);
    }

    // 해당 M번째 문서가 몇번째로 인쇄
    static int find(int M){
        int cnt = 0; //M이 몇번째로 인쇄되었는지 저장하는 변수

        while(!queue.isEmpty()){ //큐가 비어있을 때까지 반복한다.

            int[] first = queue.poll(); //큐의 맨 앞 요소를 뺀다.
            boolean isMax = true; 

            //중요도 검사
            for(int i = 0; i < queue.size(); i++){

                //지금 뽑은 요소의 중요도보다 큰 것이 있을 경우
                if(first[1] < queue.get(i)[1]){

                    queue.offer(first); //뽑은 해당 요소를 맨 뒤에 넣고

                    //반복하면서 마주한 뽑은 요소(first)보다 안 큰 요소들 또한 맨뒤에 넣는다.
                    for(int j = 0; j < i; j++){
                        //queue의 i번째에 first(뽑은 요소)보다 큰 게 있는 것이므로
                        // i까지만 반복한다.
                        queue.offer(queue.poll());
                    }

                    isMax = false; // 해당 뽑은 요소(first)보다 큰 요소 존재
                    break; // 걸러졌으므로 반복문을 나온다.
                }
            }

            if(isMax == false){ //뽑은 요소보다 큰 요소가 있어서 걸러졌다면 다시 반복문을 돌아야한다.(밑은 수행X)
                continue;
            }

            //first가 가장 큰 요소인 거니까
            cnt++; 

            if(first[0] == M){ //찾는 요소일 경우 반복문을 빠져나가서
                break;
            }
        }

        return cnt; //큰 요소를 누적 개서 더하기 한거를 반환
    }
}