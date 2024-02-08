package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_1057_토너먼트 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		int yim = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int answer = -1;
		int cnt = 0;
		while(yim != kim) {
			cnt++;
			yim = (yim+1) >> 1;
			kim = (kim+1) >> 1;
			if(yim == kim) answer = cnt;
		}
		bw.append(answer + "");
		bw.close();
		br.close();

	}

}