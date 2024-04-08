package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2839_설탕_배달 {
	static int[] arr = new int[5001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		arr[1] = -1;
		arr[2] = -1;
		arr[3] = 1;
		arr[4] = -1;
		arr[5] = 1;
		arr[6] = 2;
		arr[7] = -1;
		arr[8] = 2;
		arr[9] = 3;
		arr[10] = 2;
		arr[11] = 3;
		arr[12] = 4;
		if(n<13) {
			System.out.println(arr[n]);
			return;
		}
		
		bw.append(dp(n) + "");
		bw.flush();
		bw.close();
		br.close();
	}
	static int dp(int n) {
		if(arr[n] != 0) return arr[n];
		return arr[n] = dp(n-5)+1;
	}
	
	
}
