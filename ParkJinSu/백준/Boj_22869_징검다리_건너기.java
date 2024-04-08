package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_22869_징검다리_건너기 {
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		visit = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp(0,n,k);
		if(visit[n-1]) {
			bw.append("YES");
		}else {
			bw.append("NO");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dp(int start, int end, int k) {
		visit[start] = true;
		for(int i=start; i<end; i++) {
			if(!visit[i] && k>=(i-start) *(1+Math.abs(arr[start] - arr[i]))) {
				dp(i,end,k);
			}
		}
		
		
	}
		
}