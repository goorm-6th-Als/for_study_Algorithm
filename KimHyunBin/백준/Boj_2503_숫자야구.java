import java.util.*;
import java.io.*;

public class Main { // 2503_숫자야구
	private static int N, cnt = 0;
	private static boolean[] num = new boolean[988];
	private static final int MIN_NUMBER = 123;
	private static final int MAX_NUMBER = 987;

	static {
		// 0이나 중복되는 경우 먼저 제거.
		for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
			int a = i / 100, b = i % 100 / 10, c = i % 10;
			if (a == 0 || b == 0 || c == 0 || a == b || b == c || a == c) {
				num[i] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		for (int T = 0; T < N; T++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());

			check(num, strike, ball);
		}

		for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
			if (!num[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	public static void check(int number, int strike, int ball) {
		int a = number / 100;
		int b = number % 100 / 10;
		int c = number % 10;

		for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
			if (num[i])
				continue;
			int a2 = i / 100;
			int b2 = i % 100 / 10;
			int c2 = i % 10;
			int strikeCount = calculateStrike(a, b, c, a2, b2, c2);
			int ballCount = calculateBall(a, b, c, a2, b2, c2);
			if (strike != strikeCount || ball != ballCount)
				num[i] = true;
		}
	}

	private static int calculateStrike(int a, int b, int c, int a2, int b2, int c2) {
		int strike = 0;
		if (a == a2)
			strike++;
		if (b == b2)
			strike++;
		if (c == c2)
			strike++;
		return strike;
	}

	private static int calculateBall(int a, int b, int c, int a2, int b2, int c2) {
		int ball = 0;
		if (a == b2 || a == c2)
			ball++;
		if (b == a2 || b == c2)
			ball++;
		if (c == b2 || c == a2)
			ball++;
		return ball;
	}
}
