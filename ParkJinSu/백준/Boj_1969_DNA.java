package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringBufferInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Boj_2606_바이러스 {
	static boolean visit[];
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] cnt;
		int hd = 0, max = 0;
		String[] dnaArr = new String[n];
		StringBuffer dna = new StringBuffer();
		for(int i = 0; i<n; i++){
			dnaArr[i] = br.readLine();
		}
		for(int i=0; i<m;i++) {
			/*
			 * A=0
			 * C=1
			 * G=2
			 * T=3
			 */
			cnt = new int[4]; 
			for(int j=0; j<n; j++) {
				switch (dnaArr[j].charAt(i)) {
				case 'A':
					cnt[0]++;
					break;
				case 'C':
					cnt[1]++;
					break;
				case 'G':
					cnt[2]++;
					break;
				case 'T':
					cnt[3]++;
					break;
				}
			}
			max = 0;
			for(int j=0; j<4; j++) {
				max = Math.max(max, cnt[j]);
			}
			for(int j=0; j<4; j++) {
				if(max == cnt[j]) {
					if(j == 0) dna.append("A");
					else if(j == 1) dna.append("C");
					else if(j == 2) dna.append("G");
					else if(j == 3) dna.append("T");
					break;
				}
			}
			hd += n-max;
		}
		bw.append(dna+"\n");
		bw.append(hd+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	
}
