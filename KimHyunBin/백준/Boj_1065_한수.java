import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main { // Boj_1065_한수
	public static int N, answer;

	// 점수가 바뀌는 구간에서 시간차이를 주어야 함.
	// 만약 1이 이기다가 2가 된다면 1에게 그 차이만큼 시간 ++
	// 동점이었다가 이긴다면 이긴쪽에게 시간을 부여해서 계산
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		if (N < 100) {
			sb.append(N);
		} else if (N == 1000) {
			sb.append(144);
		} else {
			answer = 99;
			// 무조건 3자리 100 ~ 999
			for (int num = 100; num <= N; num++) {
				int a1 = num / 100;
				int a2 = (num / 10) % 10;
				int a3 = num % 10;
				if (a1 - a2 == a2 - a3) {
					answer++;
				}
			}
			sb.append(answer);
		}
		System.out.println(sb);
	}
}
