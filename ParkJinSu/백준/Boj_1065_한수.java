package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import javax.net.ssl.SSLContext;
public class Boj_1065_한수 {
	
	static int answerArr[];
	static int answer = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt=0;
		int n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			if(i<100) {
				cnt++;
			}else if((i/100)-((i%100)/10) == ((i%100)/10) - i%10) cnt++;
		}
		bw.append(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
}