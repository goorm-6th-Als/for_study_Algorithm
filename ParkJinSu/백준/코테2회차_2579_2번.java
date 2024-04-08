package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import javax.net.ssl.SSLContext;
public class 코테2회차_2579_2번 {
	static int stairs[];
	static int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		stairs = new int[n];
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		stairs[0] = arr[0];
		if(n == 1 ) {
			System.out.println(arr[0]);
			return;
		}
		stairs[1] = arr[0] + arr[1];
		if(n == 2) {
			System.out.println(stairs[1]);
			return;
		}
		stairs[2] = arr[2]+Math.max(arr[0],arr[1]);
		if(n == 3) {
			System.out.println(stairs[2]);
			return;
		}
		bw.append(dp(n-1)+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int dp(int index) {
		if(stairs[index] > 0) return stairs[index];
		
		return stairs[index] = Math.max(dp(index-3) + arr[index] +arr[index-1],dp(index-2)+arr[index]);
		
	}
}