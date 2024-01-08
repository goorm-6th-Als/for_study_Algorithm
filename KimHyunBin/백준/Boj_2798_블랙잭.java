import java.util.*;
import java.io.*;

public class Main { // 2798_블랙잭

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					int temp = num[i] + num[j] + num[k];
					if (temp <= M) {
						answer = Math.max(answer, temp);
					}
				}
			}	
		}
		System.out.println(answer);
	}
}
