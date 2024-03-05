import java.util.*;
import java.io.*;

public class Main { // Boj_20125_쿠키의 신체 측정
	public static int N, left, right, waist, L_leg, R_leg, heart_r, heart_c, waist_end_r, waist_end_c;
	public static char[][] cookie;
	public static int[] dr = { 1, -1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static boolean[][] visit;

	// +- 1칸, +- A or +- B칸, A *, B * 칸.
	// 모든 경우 다 que에 넣어서 visit 체크
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		cookie = new char[N + 1][N + 1];
		visit = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			s = br.readLine();
			for (int j = 1; j <= N; j++) {
				cookie[i][j] = s.charAt(j - 1);
			}
		}
		// for_chk_input
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=N; j++) {
//				System.out.print(cookie [i][j]+" "); 
//			}
//			System.out.println(); 
//		}
		for (int i = 2; i <= N - 1; i++) {
			for (int j = 2; j <= N - 1; j++) {
				if (cookie[i][j] == '*') {
					// 심장 체크
					if (cookie[i - 1][j] == '_' || cookie[i + 1][j] == '_' || cookie[i][j - 1] == '_'
							|| cookie[i][j + 1] == '_')
						continue;
					heart_r = i;
					heart_c = j;
				}
			}
		}

		// 왼팔
		for (int j = heart_c-1; j >= 1; j--) {
			if (cookie[heart_r][j] != '*')
				break;
			left++;
		}

		// 오른팔
		for (int j = heart_c+1; j <= N; j++) {
			if (cookie[heart_r][j] != '*')
				break;
			right++;
		}
		// 허리
		for (int j = heart_r+1; j <= N; j++) {
			if (cookie[j][heart_c] != '*') {
				waist_end_r = j-1;
				waist_end_c = heart_c;
				break;
			}
			waist++;
		}
		// L 다리
		for (int j = waist_end_r + 1; j <= N; j++) {
			if (cookie[j][waist_end_c -1] != '*')
				break;
			L_leg++;
		}
		// R 다리
		for (int j = waist_end_r + 1; j <= N; j++) {
			if (cookie[j][waist_end_c + 1] != '*')
				break;
			R_leg++;
		}
		
		sb.append(heart_r + " " +heart_c + "\n");
		sb.append(left + " " + right + " " + waist + " " + L_leg + " " + R_leg);
		
		System.out.println(sb);
	}
}