package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Boj_10870_피보나치_수5 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int loop = Integer.parseInt(br.readLine());
		if(loop == 1) {
			bw.append(1+"");
			
			bw.flush();
			bw.close();
			br.close();
			return;
			
		}
		int a,b,c;
		a=0;
		b=1;
		c=0;
		for(int i=1; i<loop; i++) {
			c = a+b;
			a = b;
			b = c;
		}
		bw.append(c+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	
}
