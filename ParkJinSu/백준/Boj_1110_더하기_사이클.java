package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Boj_1110_더하기_사이클 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0, left=0, right=0;
		int cycle = N;
		do {
			cnt++;
			left = cycle/10;
			right = cycle%10;
			
			cycle = (right * 10) + ((left+right)%10);
		} while (N != cycle);
		
		bw.append(cnt+"");
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
