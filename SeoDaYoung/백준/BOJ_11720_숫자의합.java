import java.util.Scanner;

public class BOJ_11720_숫자의합 {
	public static void main(String[] args) {	
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        String a = in.next();
        in.close();
        
        int sum = 0;
        
        for (int i=0; i<n; i++) {
            sum += a.charAt(i)-'0'; // 문자열의 첫 번째 원소부터 마지막 원소까지 누적합
                                    // charAt()은 아스키코드값을 반환하므로 -48 또는 -'0'
        }
        System.out.println(sum);
    }
}