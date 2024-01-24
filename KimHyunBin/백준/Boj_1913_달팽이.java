import java.util.*;
import java.io.*;

public class Main { // Boj_1913_달팽이
	public static int N, M, loc_row, loc_col;
	public static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		int num = (int) Math.pow(N, 2);
		arr = new int[N + 1][N + 1];
		loc_row = 0;
		loc_col = 0;
		down(0, 0, num);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		sb.append(loc_row + " " + loc_col);
		System.out.println(sb);
	}

	public static void down(int row, int col, int num) {

		for (int i = row; i <= N; i++) { // 열 고정, 막히면 col -> i

			if (rangechk(i, col)) {
				if(find_num(num)) {
					loc_row = i+1;
					loc_col = col+1;
				}
				arr[i][col] = num;
				num--;
			} else {
				right(i - 1, col + 1, num); // row 위로 땡겨주기, col 우측으로 한칸
				return;
			}
			if (end(num)) {
				return;
			}
		}
	}

	public static void right(int row, int col, int num) {

		for (int i = col; i <= N; i++) { // 행 고정, 막히면 row -> i

			if (rangechk(row, i)) {
				if(find_num(num)) {
					loc_row = row+1;
					loc_col = i+1;
				}
				arr[row][i] = num;
				num--;
			} else {

				up(row - 1, i - 1, num);
				return;
			}
			if (end(num)) {
				return;
			}
		}
	}

	public static void up(int row, int col, int num) {

		for (int i = row; i >= -1; i--) { // 열 고정, 막히면 col -> i

			if (rangechk(i, col)) {
				if(find_num(num)) {
					loc_row = i+1;
					loc_col = col+1;
				}
				arr[i][col] = num;
				num--;
			} else {
				left(i + 1, col - 1, num);
				return;
			}
			if (end(num)) {
				return;
			}
		}
	}

	public static void left(int row, int col, int num) {

		for (int i = col; i >= -1; i--) { // 행 고정, 막히면 row -> i
			
			if (rangechk(row, i)) {
				if(find_num(num)) {
					loc_row = row+1;
					loc_col = i+1;
				}
				arr[row][i] = num;
				num--;
			} else {
				down(row + 1, i + 1, num);
				return;
			}
			if (end(num)) {
				return;
			}
		}
	}

	public static boolean find_num(int num) { // 번호 인덱스 찾기
		return num == M;
	}

	public static boolean end(int num) { // 이걸 안해서 무한루프..
		return (num == 0);
	}

	public static boolean rangechk(int row, int col) { // 처음 가는곳이고 바깥으로 나가지 않아야 함.
		return (row >= 0 && col >= 0 && row < N && col < N && arr[row][col] == 0);
	}
}