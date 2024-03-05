import java.io.*;
import java.util.*;

class Main { // Boj_16234_인구 이동_G4
	public static ArrayList<int []> nation;
	public static int[][] people;
	public static boolean[][] visit;
	public static int N, L, R, answer, sum;
	public static int [] dx = {1,-1,0,0};
	public static int [] dy = {0,0,1,-1};
	public static boolean close;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		people = new int[N][N];
		// input -------------------------------
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				people[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// -------------------------------------
		answer = 0;
		while(true) {
			visit = new boolean[N][N];
			close = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (chk(i, j)) {
						sum = 0;
						bfs(i, j);

						if (nation.size() > 1) {
							addPeople();
							close = true;
						}
					}
				}
			}
			if (!close) {
				break;
			}else {
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static void bfs(int x, int y) {
//       System.out.println("bfs 시작 지점 x:" + x + " y:" + y);
		nation = new ArrayList<>();
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x, y});
		visit[x][y] = true;
		sum = people[x][y];
		nation.add(new int[]{x, y}); // 맞네.. 초기도 넣어야지
		while (!que.isEmpty()) {
			int[] now = que.poll();
			int n_x = now[0];
			int n_y = now[1];

			for (int i = 0; i < 4; i++) {
				int nx = n_x + dx[i];
				int ny = n_y + dy[i];

				if (chk(nx,ny)) {
					int now_people = people[n_x][n_y];
					int next_people = people[nx][ny];
					int sub = Math.abs(now_people - next_people);

					if (L <= sub && sub <= R) {
//                        System.out.println("범위 안 차이 :" + sub + "현재 값: " +now_people+ " 비교대상:"+ next_people);
						nation.add(new int[]{nx, ny});
						que.add(new int[] {nx, ny});
						visit[nx][ny] = true;
						sum += people[nx][ny];
					}
				}
			}
		}
	}

	public static void addPeople(){

		for(int i = 0; i<nation.size(); i++){
			int [] location = nation.get(i);
			int x = location[0];
			int y = location[1];
			people[x][y] = sum/nation.size();
//            System.out.println(people[x][y]);
		}
	}
	public static boolean chk(int x, int y){
		return 0<=x && 0<=y && x<N && y<N && !visit[x][y];
	}
}

