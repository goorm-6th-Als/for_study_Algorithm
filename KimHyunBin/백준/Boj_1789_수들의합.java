import java.util.*;
import java.io.*;

public class Main {// Boj_1789_수들의합
	static long N;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		answer = 0;
		N = Long.parseLong(st.nextToken());
		long sum = 0;

		for(int i = 1; i<=N; i++) {
			answer += 1;
			sum += i;
			if(sum > N) {
				answer -= 1;
				break;
			}
			
		}
		
		System.out.println(answer);
	}
}