import java.util.*;
import java.io.*;

public class Main { //2581번 소수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		if(M <2) M = 2;

		boolean [] prime = new boolean[N+1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false; // 0과 1은 소수가 아님

		for(int i = 2; i <= Math.sqrt(N); i++) {
			if(prime[i]) {
				for(int j = i*i; j <= N; j += i) {
					prime[j] = false;
				}
			}
		}

		List<Integer> list = new ArrayList<>();
		for(int i = M; i <= N; i++) {
			if(prime[i]) {
				list.add(i);
			}
		}

		if(list.isEmpty()) {
			sb.append("-1");
		} else {
			int answer_sum = 0;
			for(int temp : list) {
				answer_sum += temp;
			}

			int answer_min = list.get(0);

			sb.append(answer_sum).append("\n");
			sb.append(answer_min);
		}

		System.out.println(sb);
	}
}
