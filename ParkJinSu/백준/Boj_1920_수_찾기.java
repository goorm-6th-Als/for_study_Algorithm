package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Boj_1920_수_찾기 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int arr1[];
		arr1= new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			 bw.append(bs(Integer.parseInt(st.nextToken()), arr1) +"\n");
			
		}
		
		
		bw.append("");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int bs(int n, int[] arr) {
		int right = arr.length-1;
		int left=0;
		int mid;
		
		while(left<=right) {
			mid = (left+right)/2;
			if(arr[mid] < n) left = mid+1;
			else if(arr[mid] > n) right = mid-1;
			else return 1;
		}
		return 0;
	}
	
}