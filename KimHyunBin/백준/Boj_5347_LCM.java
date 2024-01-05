import java.util.*;
import java.io.*;

public class Main { // 5347번 LCM 
	// a*b / 최소공약수 = 최소 공배수.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	int big = Math.max(a,b);
            int small = Math.min(a,b);
            long answer = big * small;
            while(small != 0) {
            	int temp = small;
            	small = big % small;
            	big = temp;
            }
            int gcd = big;
            answer /= gcd;
            System.out.println(answer);
        }
    }
}
