package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 코테3회차_1748_1번 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer=0;
		int up = 1;
		int level = 10;
		int n = Integer.parseInt(st.nextToken());
//		var answer=0;
//		var up = 1;
//		var level = 10;
//		var n = Integer.parseInt(st.nextToken());
		for(int i=1; i<=n;i++) {
			if(i % level == 0) {
				up++;
				level *= 10;
			}
			answer+=up;
		}
		bw.append(answer + "");
		bw.close();
		br.close();

	}

}