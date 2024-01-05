import java.util.*;
import java.io.*;

public class Main { // 1010_다리놓기
	// dp, 조합
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		//M개 중에서 N개를 뽑아 고르기. mCn
		//nCr + nCr+1 = n+1 C r+1
		// 3C1 + 3C2 = 4C2
		int dp [][] = new int [31][31];
		for(int i = 1; i<31; i++) {
			dp[i][1] = i;
		}
		
		for(int i = 2; i<31; i++) {
			for(int j = 2; j<31; j++) {
				dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
			}
		}
		
		// input
		for (int Tc = 1; Tc <= T; Tc++) {			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());			
			System.out.println(dp[M][N]);
		}
		
		
	}
}
