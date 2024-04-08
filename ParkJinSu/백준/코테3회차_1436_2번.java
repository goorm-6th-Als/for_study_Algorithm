package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 코테3회차_1436_2번 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer =666;
		int b = Integer.parseInt(st.nextToken());
		int cnt=0;
		while(cnt != b) {
			if((answer+"").contains("666")) cnt++;
			answer++;
		}
		bw.append(--answer + "");
		bw.close();
		br.close();

	}

}