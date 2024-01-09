package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Boj_2490_윷놀이 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] game = {'D','C','B','A','E'};
		StringTokenizer st;
		/*
		 * 0 1 1 1 도 A
		 * 0 0 1 1 개 B
		 * 0 0 0 1 걸 C
		 * 0 0 0 0 윷 D 
		 * 1 1 1 1 모 E
		 */
		int cnt;
		for(int i=0; i<3; i++) {
			cnt=0;
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				cnt += Integer.parseInt(st.nextToken());
			}
			bw.append(game[cnt] +"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}
