import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {

        int N = friends.length;
        Map<String, Integer> map = new HashMap<>();
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            map.put(friends[i], i);
        }

        int A, B;
        for(int i = 0; i < gifts.length; i++) {

            A = map.get(gifts[i].split(" ")[0]);
            B = map.get(gifts[i].split(" ")[1]);

            arr[A][B]++;
        }

        int[] points = new int[N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                points[i] += arr[i][j];
                points[j] -= arr[i][j];
            }
        }

        int[] res = new int[N];
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(arr[i][j] > arr[j][i]) res[i]++;
                else if(arr[i][j] < arr[j][i]) res[j]++;
                else {
                    if(points[i] > points[j]) res[i]++;
                    else if(points[i] < points[j]) res[j]++;
                }       
            }
        }

        int max = 0;

        for(int i = 0; i < N; i++) if(max < res[i]) max = res[i];

        return max;
    }
}