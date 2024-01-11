import java.util.*;
import java.io.*;

public class Main {// Boj_2750_수 정렬하기
	static int N, M, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		
		int arr [] = new int [N];
		for(int i = 0; i<N; i++) {
			arr [i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		for(int a : arr) {
			System.out.println(a);
		}
	}
}