import java.util.*;
import java.io.*;

public class Main { // Boj_12761_돌다리
	public static int A,B,N,M;
	public static int[] location = new int [100001];
	public static int[] arr = new int [8];
	public static boolean [] visit = new boolean [100001];;
	// +- 1칸, +- A or +- B칸, A *, B * 칸.
	// 모든 경우 다 que에 넣어서 visit 체크
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Queue<Integer> que = new LinkedList<>();
		que.add(N);
		while(!que.isEmpty()) {
			int now = que.poll(); // 현재 위치에서 가능한 모든 값 넣기.
			arr[0] = now - 1; arr[1] = now + 1; arr[2] = now + A; arr[3] = now - A;
			arr[4] = now + B; arr[5] = now - B; arr[6] = now * A; arr[7] = now * B;
			for (int i = 0; i<8; i++) {
				if(range(i)) { // 0 <= 범위 <=100000 && 방문하지 않은곳 확인
					visit[arr[i]] = true;
					location[arr[i]] = location[now] + 1; //위치에 도달하는 횟수 저장
					if(location[M] != 0) {
						break;
					}
					que.add(arr[i]); // 다음 위치 추가
				}
			}
		}
		System.out.println(location[M]);
	}
	public static boolean range (int num) {
		return arr[num] >= 0 && arr[num] <= 100000 && !visit[arr[num]];
	}
}