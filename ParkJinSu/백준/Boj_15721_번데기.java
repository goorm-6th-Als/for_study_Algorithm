package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Boj_15721_번데기 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int answer=0;
		// 1회차 0 1 0 1 0 0 1 1 | 8
		// 2회차 0 1 0 1 0 0 0 1 1 1 | 10
		// 3회차 0 1 0 1 0 0 0 0 1 1 1 1 | 12
		
		
	
		int round=8; //cnt-1 회차에 나오는 뻔, 데기 들의 수
		int cnt = 2; //cnt-1 회차 뻔 뻔 데기 데기
		while(t*2 > round ) {
			t -= round/2; 
			answer += round;
			round += 2;
			cnt++;
		}
		
		
		
		if(t<3) { // 앞 4자리는 항상 같아서 따로 빼둠
			if(n == 0) answer += t== 1 ? 0:2;
			else answer += t == 1? 1:3;
		}
		else {
			answer += t+1;//"뻔"일때
			if(n == 1 ) answer += cnt; //데기 일때 회차+1만큼 더해줌
		}
		
		bw.append(answer%a+"");//사람 수대로 나눠줌
		bw.flush();
		bw.close();
		br.close();
	}
	
}