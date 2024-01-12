package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Boj_2512_예산 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int left=0, right=0;
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}
		int max = Integer.parseInt(br.readLine());
		int mid;
		long budget;
		while(left <= right) { 
			budget = 0;
			mid = (left+right)/2;
			for(int i=0; i<N; i++) {
				if(arr[i] >= mid) budget += mid;
				else budget += arr[i];
			}
			if(max >= budget) left = mid+1;
			else right = mid-1;
		}
		bw.append(right + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}