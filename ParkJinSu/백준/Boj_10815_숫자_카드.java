package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Boj_10815_숫자_카드 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			bw.append(bs(Integer.parseInt(st.nextToken()), arr)+" ");
		}
		bw.append("");
		bw.flush();
		bw.close();
		br.close();
	}
	static int bs(int n , int[] arr) {
		int left=0;
		int right = arr.length;
		int mid;
		while(left<=right) {
			mid = (left+right)/2;
			if(arr[mid] > n) right = mid-1;
			else if(arr[mid] < n) left = mid+1;
			else return 1;
		}
		
		return 0;
	}
	
	
	
}