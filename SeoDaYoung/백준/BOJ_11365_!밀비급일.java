import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
        Scanner in = new Scanner(System.in);
        
        String s = "";
        
        while(true) {
            s = in.nextLine();
            if(s.equals("END")) {
                break;
            }
        
        String[] arr = s.split(""); // 하나씩 쪼개 배열에 넣음
        
        for (int i=arr.length-1; i>=0; i--){
            System.out.print(arr[i]);
        }
        System.out.println();
        }
    in.close();
    }
}