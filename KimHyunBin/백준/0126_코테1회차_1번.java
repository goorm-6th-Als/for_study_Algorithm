import java.util.*;
import java.io.*;

public class Main { // Boj_2563_색종이
	public static int N, x, y, answer;
	public static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[101][101];
		int length = 10;
		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for(int i = x; i<x+10; i++) {
				for(int j = y; j<y+10; j++) {
					map[i][j] = 1;
				}
			}
		}

		
		for(int i = 0; i<101; i++) {
			for(int j = 0; j<101; j++) {
				if(map[i][j] == 1) {
					answer ++;
				}
			}
		}

		System.out.println(answer);

	}
}