import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int[] skills = new int[4];
        for(int i = 0; i < 4; i++) {
            skills[i] = scanner.nextInt();
        }
        
        Arrays.sort(skills);
        int difference = Math.abs((skills[0] + skills[3]) - (skills[1] + skills[2]));
        System.out.println(difference);
        scanner.close();
    }
}
