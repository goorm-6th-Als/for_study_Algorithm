package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_11720_숫자의_합 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		String num = br.readLine();
		
		for(int i=0; i<N; i++) {
			sum += Integer.parseInt(num.charAt(i)+"");
		}
		bw.append(sum+"");
		
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
