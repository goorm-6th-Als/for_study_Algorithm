package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Boj_2563_색종이 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int answer=0, sw, sh;
		boolean paper[][] = new boolean[101][101];
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			sw= Integer.parseInt(st.nextToken());
			sh= Integer.parseInt(st.nextToken());
			for(int j=sw; j<sw+10;j++) {
				for(int q=sh; q<sh+10; q++) {
					if(!paper[j][q]) {
						answer++;
						paper[j][q] = true;
					}
				}
			}
				
		}
		bw.append(answer+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
}