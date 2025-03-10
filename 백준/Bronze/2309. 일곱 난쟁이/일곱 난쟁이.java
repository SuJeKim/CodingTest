import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		
		for(int i = 0; i<9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}	
		Arrays.sort(arr);
		int out1 = 0;
		int out2 = 0;
		
		for(int i =0; i < 8; i++) {
			for(int j = i+1; j < 9; j++) {
				if(sum - arr[i] -arr[j] == 100) {
					out1 = i;
					out2 = j;
				}
			}
		}
		for(int i =0; i< 9; i++) {
			if(i != out1 && i != out2) {
				System.out.println(arr[i]);
			}
		}

}
}
