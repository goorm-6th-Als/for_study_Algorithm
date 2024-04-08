package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Boj_1436_영화감독_숌 {
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int answer=666;
		while(n != cnt) {
			if(String.valueOf(answer).contains("666")) cnt++;
			
			answer++;
		}
		answer--;
		bw.append(answer+"");
		bw.flush();
		bw.close();
		br.close();
	}
	

}