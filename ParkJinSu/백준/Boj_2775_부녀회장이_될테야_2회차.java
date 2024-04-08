package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2775_부녀회장이_될테야_2회차 {
	static int[][] arr = new int[15][15];
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int y;
		int x;
		for(int i=0; i<n; i++) {
			y = Integer.parseInt(br.readLine());
			x= Integer.parseInt(br.readLine());
			bw.append(dp(y,x-1)+"\n");
		}
			
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int dp(int y, int x) {
		if(arr[y][x] != 0) return arr[y][x];
		else if(y == 0) return arr[y][x] = x+1;
		else if(x == 0) return arr[y][x] = 1;
		return arr[y][x] = dp(y-1,x) + dp(y,x-1);
	}
	

	
	
}