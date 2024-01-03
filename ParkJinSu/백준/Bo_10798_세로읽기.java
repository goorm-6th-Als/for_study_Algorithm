package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bo_10798_세로읽기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[][] ch = new char[5][15];
		String str;
		int max=0;
		for(int i=0; i<ch.length; i++) {
			str = br.readLine();
			max = Math.max(max, str.length());
			for(int j=0; j<str.length();j++) {
				ch[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<max; i++) {
			for(int j=0; j<5; j++) {
				if(ch[j][i] != '\0') bw.append(ch[j][i]);
			}
		}
		
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
