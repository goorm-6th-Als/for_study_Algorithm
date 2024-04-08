package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Boj_1010_다리놓기 {
	static int[][] arr = new int[30][30];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int loop = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int tmp;
		for(int i=0; i<loop; i++) {
			st= new StringTokenizer(br.readLine());
			tmp = Integer.parseInt(st.nextToken());
			bw.append(ncr(Integer.parseInt(st.nextToken()), tmp)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static int ncr(int n,int r) {
		System.out.println(n + "  " +r);
		if(arr[n][r]>0) return arr[n][r];
		if(n == r || r==0) {
			return 1;
		}else return arr[n][r] = ncr(n-1,r-1) + ncr(n-1, r); 
		
		
	}
}
