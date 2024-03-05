import java.util.*;
import java.io.*;

public class Main {// Boj_11663_선분위의점
	// 이분탐색
	static int answer, N, M;
	static int[] node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder ();
		N = Integer.parseInt(st.nextToken()); // 점의 개수
		M = Integer.parseInt(st.nextToken()); // 선분의 개수
		node = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(node);
		
		//logic
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			int low = 0;
			int high = node.length-1;
			while(low <= high) {
				int mid = (high + low)/2;
				if(node[mid] < min) { // 중앙이 선의 최소보다 작으면.
					low = mid+1; // idx 최소 범위 변경
				}else {
					high = mid-1; // 크다면 idx 최대범위 변경
				}
			}
			int startidx = low;
			
			// 초기화
			low = 0;
			high = node.length-1;
			
			while(low <= high) {
				int mid = (high + low)/2;
				if(node[mid] > max) { // 중앙이 선의 최대보다 크면
					high = mid-1; // idx 최대 범위 변경
				}else {
					low = mid+1; // 크다면 idx 최대범위 변경
				}
			}
			int lastidx = high+1;
			answer = lastidx - startidx;

			sb.append(answer);
			sb.append("\n");
		}
		System.out.println(sb);
		System.out.println((4+2)/2);
	}
}