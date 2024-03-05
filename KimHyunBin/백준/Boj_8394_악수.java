import java.io.*;
import java.util.StringTokenizer;

public class Main {// Boj_8394_악수
    // DP
    public static int N,answer;
    public static int []dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int [Math.max(4,N+1)];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i =3 ; i<=N; i++){
            dp[i] = ((dp[i-1] % 10) + (dp[i-2] % 10)) % 10;
        }
        System.out.println(dp[N]);

    }
}
