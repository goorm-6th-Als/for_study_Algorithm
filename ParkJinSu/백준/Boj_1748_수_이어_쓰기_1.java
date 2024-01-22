package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Boj_1748_수_이어_쓰기_1 {

	static StringBuilder sb = new StringBuilder();
	static StringBuilder ub = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		long answer;
		if(n<10) {
			System.out.println(n);
			return;
		}
		else answer = 9;
		int num = 100;
		int cnt = 2;
		while(num <= n) {
			//System.out.println("num = "+num);
			answer += (num - (num/10))*cnt; // (단위 - 단위10%)*자릿수 100 1 ~ 9 ((10 ~ 99) * 자릿수) 10000 1000 ~ 9999
			//System.out.println(answer);
			num *= 10;
			cnt++;
		}
		int tmp = n/(num/10)-1;
		
		answer += ((tmp*num/10)+(n%(num/10))) * cnt +cnt;
		
		//9991  38857
		bw.append(answer+"");
		bw.close();
		br.close();
	}
	
	

}
