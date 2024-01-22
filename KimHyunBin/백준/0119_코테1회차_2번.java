import java.io.*;
import java.util.*;

public class Main { // Boj_1789_수들의합
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		long sum = 0;
		int answer = 0;
		for (long i = 1; i <= N; i++) {
			sum += i;	
			if (N < sum) {
				break;
			}
			answer++;
		}
		System.out.println(answer);
	}
}
