package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Boj_2798_블랙잭 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int max=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=n-1; i>1; i--) {
			for(int j=i-1; j>0;j--) {
				if(arr[i]+arr[j] > m) continue;
				for(int k=j-1; k>=0;k--) {
					if(arr[i]+arr[j]+arr[k] <= m) {
						max = Math.max(max, arr[i]+arr[j]+arr[k]);
					}
				}// for k
			}// for j
		}//for i
		
		bw.append(max+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
