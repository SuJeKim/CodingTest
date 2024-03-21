import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int V =  Integer.parseInt(sc.nextLine());
        String votes = sc.nextLine(); // 투표 결과 문자열
        
        int countA = 0;
        int countB = 0;
        
        for (int i = 0; i < votes.length(); i++) {
            if (votes.charAt(i) == 'A') {
                countA++;
            } else if (votes.charAt(i) == 'B') {
                countB++;
            }
        }
        
        if (countA > countB) {
            System.out.println('A');
        } else if (countA < countB) {
            System.out.println('B');
        } else {
            System.out.println("Tie");
        }
        
        sc.close();
    }
}
