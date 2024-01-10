package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Boj_2579_계단_오르기 {
	static Integer dp[];
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr= new int[N+1];
		dp= new Integer[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 0;
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		bw.append(find(N)+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static int find(int N) {
		if(dp[N] != null) return dp[N];
		
		return dp[N] = Math.max(find(N-3)+arr[N-1], find(N-2)) + arr[N];
	}
}
