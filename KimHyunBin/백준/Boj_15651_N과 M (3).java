import java.util.*;
import java.io.*;

public class Main {// Boj_1748_수 이어 쓰기1
	static int N, digit;
	static long answer ;
	static StringBuilder sb;
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		// 1~9 -> 그대로, 10~99 -> 2자리씩, 100 ~ 999 -> 3세자리
		digit = 10;
		answer = 0;
		int cnt = 1;
		for(int i = 1; i<=N; i++) {
			if( i == digit ) {
				digit *= 10;
				cnt += 1;
			}
			answer += cnt;
		}
	

		System.out.println(answer);

	}
}
