import java.util.*;
import java.io.*;
public class Main { // Boj_19941_햄버거 분배
	public static int N, K, answer;
	public static char[] arr;
	public static boolean[] ate;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new char[N];
		ate = new boolean[N];

		String s = br.readLine();
		for (int i = 0; i < N; i++) {
			arr[i] = s.charAt(i);
		}

		for (int i = 0; i < N; i++) {
			if (arr[i] != 'P')
				continue;
			for (int j = i - K; j <= i + K; j++) {
				if (j < 0 || j >= N)
					continue;
				if (arr[j] == 'H' && !ate[j]) {
					ate[j] = true;
					answer += 1;
					break;
				}
			}
		}
		System.out.println(answer);

	}
}