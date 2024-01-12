package aubetou;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2503_숫자야구 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[] answer = new boolean[988];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int loop = Integer.parseInt(br.readLine());
		int num, a, b, c, a2,b2,c2;
		int strike, ball, strikeCnt, ballCnt;
		int ans =0; 
	
		for(int i=123; i<988; i++) {
			a = i/100;
			b = i%100/10;
			c = i%10;
			if(a==0 || b==0 || c==0) continue;
			else if(a==b || a==c || b==c) continue;
			answer[i] = true;
		}
		
		for(int i=0; i<loop;i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			strike = Integer.parseInt(st.nextToken());
			ball = Integer.parseInt(st.nextToken());
			a2 = num/100;
			b2 = num%100/10;
			c2 = num%10;
			for(int j=123; j<988; j++) {
				
				strikeCnt =0;
				ballCnt=0;
				if(answer[j]) {
					a = j/100;
					b = j%100/10;
					c = j%10;
					if(a == a2) strikeCnt++;
					if(b == b2) strikeCnt++;
					if(c == c2) strikeCnt++;
					if(a2 == b || a2 ==c) ballCnt++;
					if(b2 == a || b2 ==c) ballCnt++;
					if(c2 == a || c2 ==b) ballCnt++;
					
					if(strike != strikeCnt || ball != ballCnt) answer[j] = false;
					
				}
			}
		}
		
		for(int i=123; i<988;i++) {
			if(answer[i]) ans++;
		}
		bw.append(ans+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
