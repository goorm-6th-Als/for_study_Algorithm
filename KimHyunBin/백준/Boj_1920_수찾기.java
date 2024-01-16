import java.util.*;
import java.io.*;

public class Main {// Boj_1920_수찾기
	// 이분탐색
	static int N,M;
	static int [] arrN;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		arrN = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrN);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			int now_num = Integer.parseInt(st.nextToken());
			if(binary(now_num)) {
				sb.append(1);
				sb.append("\n");
			}else {
				sb.append(0);
				sb.append("\n");
			}
		}
	
		System.out.println(sb);
	}
	public static boolean binary(int num) {
		int min = 0;
		int max = N-1;

		while(min <= max) { // 찾을때까지
			int mid = (min +max)/2;
			if(arrN[mid] < num) { // 큰쪽이라면
				min = mid +1; // 최소값을 당겨주기
			}else if(arrN[mid] > num) { // 작은쪽이라면 
				max = mid -1; // 최대값을 낮춰주기
			}else {
				return true;
			}
		}
		
		return false;
	}
}