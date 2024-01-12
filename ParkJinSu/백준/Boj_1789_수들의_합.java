package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Boj_1789_수들의_합 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Long s = Long.parseLong(br.readLine());
		int n =1;
		while(s>=n) {
			s -= n;
			n++;
		}
		bw.append(--n + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
}