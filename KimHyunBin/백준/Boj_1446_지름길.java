import java.util.*;
import java.io.*;

public class Main { // Boj_1446_지름길
	public static int N, D, answer, now, idx;
	public static int[] dp;

	static class Way {
		int start;
		int end;
		int distance;

		// 지름길 객체
		Way(int start, int end, int distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}

		// 디버깅용
		@Override
		public String toString() {
			return "Way{" + "start=" + start + ", end=" + end + ", distance=" + distance + '}';
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		ArrayList<Way> short_way = new ArrayList<>();
		dp = new int[D + 1];
		Arrays.fill(dp, 10001);
		dp[0] = 0; // dp[0] 초기화 필수
		now = 0;
		idx = 0;
		// 인풋
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			// 지름길이 효율적이지 않거나, 도착지점이 D보다 크면 받지 않음
			if (end > D)
				continue;
			if (end - start <= distance)
				continue;
			short_way.add(new Way(start, end, distance));
		}

		// 시작점이 먼저 오게 정렬, 같다면 종료가 빠른 순서로
		Collections.sort(short_way, new Comparator<Way>() {
			public int compare(Way o1, Way o2) {
				if (o1.start == o2.start) {
					return o1.end - o2.end;
				}
				return o1.start - o2.start;
			}
		});

//		// 정렬 디버깅용
//		for(int i = 0; i<short_way.size(); i++) {
//			System.out.println(short_way.get(i));
//		}

		while (now < D) {
			// 지름길 업데이트
			
			if (idx < short_way.size() && short_way.get(idx).start == now) {
				Way tmp = short_way.get(idx);
				dp[tmp.end] = Math.min(dp[now] + tmp.distance, dp[tmp.end]);
				idx++;
			}
			// 고속도로
			else {
				dp[now + 1] = Math.min(dp[now + 1], dp[now] + 1);
				now++;
			}
		}

		System.out.println(dp[D]);

	}
}