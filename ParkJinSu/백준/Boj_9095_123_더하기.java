package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_9095_123_더하기 {
	
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			cnt=0;
			dp(Integer.parseInt(br.readLine()));
			bw.append(cnt+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dp(int n) {
		if(n == 0) {
			cnt++;
			return;
		}
		if(n <0)return;
		dp(n-3);
		dp(n-2);
		dp(n-1);
	}
	
	
}