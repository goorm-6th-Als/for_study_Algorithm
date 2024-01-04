package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Boj_5347_LCM {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop = Integer.parseInt(br.readLine());
		
		Long a, b, gcd;
		
		StringTokenizer st;
		for(int i=0; i<loop;i++) {
			st = new StringTokenizer(br.readLine());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			gcd = gcd(Math.max(a, b), Math.min(a, b));
			
			if(gcd == 1) {
				bw.append((a*b)+"\n");
				continue;
			}
			
			
			bw.append(((a/gcd)*b)+ "\n");
		}

		
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static Long gcd(Long left, Long right) {
		if(right == 0) return left;
		else return gcd(right, left%right);
	}
	
}
