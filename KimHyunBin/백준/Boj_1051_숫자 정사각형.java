import java.io.*;
import java.util.*;


public class Main { // Boj_1051_숫자 정사각형
	public static int N, M, answer;
	public static char [][] map ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		answer = 1;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				int start = map[i][j];
				int max_l = Math.min(N-i-1, M-j-1);
				
				for(int k = 0; k<= max_l; k++) {
//					System.out.println("r:"+i+ " c:"+ j+" " + map[i][j] + "max_l:" + max_l);
					if(square(i,j,k)) {						
						answer = (int) Math.max(answer, Math.pow(k+1,2));
					}
				}
				
			}
		}
		
		System.out.println(answer);
	
	
	}
	public static boolean square(int r, int c, int l) {
		return map[r][c] == map[r+l][c+l] && map[r+l][c+l] == 
				map[r][c+l] && map[r+l][c] == map[r][c+l];
	}
}
