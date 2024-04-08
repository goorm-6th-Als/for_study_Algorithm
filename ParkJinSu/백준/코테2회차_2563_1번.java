package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import javax.net.ssl.SSLContext;
public class 코테2회차_2563_1번 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		boolean paper[][] = new boolean[101][101];
		int answer=0;
		int y, x;
		
		for(int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			for(int j=y; j<y+10;j++) {
				for(int k=x; k<x+10; k++) {
					if(!paper[j][k]) {
						paper[j][k] = true;
						answer++;
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