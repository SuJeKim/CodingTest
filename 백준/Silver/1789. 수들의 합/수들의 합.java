import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        long S = scan.nextLong(); 
        scan.close();
        
        // 내림 Math.floor
        long answer = (long) Math.floor((-1 + Math.sqrt(1 + 8*S))/2);
        
        System.out.println(answer);
       
    }
}
