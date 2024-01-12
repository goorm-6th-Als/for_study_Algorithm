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


public class Boj_25206_너의_평점은 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Double> map = new HashMap<>();
		map.put("A+", 4.5);
		map.put("A0", 4.0);
		map.put("B+", 3.5);
		map.put("B0", 3.0);
		map.put("C+", 2.5);
		map.put("C0", 2.0);
		map.put("D+", 1.5);
		map.put("D0", 1.0);
		map.put("F", 0.0);
		double total=0, cnt = 0, answer;
		String[] str;
		for(int i=0; i<20; i++) {
			str = br.readLine().split(" ");
			if(str[2].equals("P")) continue;
			
			cnt += Double.parseDouble(str[1]);
			total += Double.parseDouble(str[1]) * map.get(str[2]);
		}
		answer = Math.round((total/cnt)*1000000)/(double)1000000;
		bw.append(answer+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
