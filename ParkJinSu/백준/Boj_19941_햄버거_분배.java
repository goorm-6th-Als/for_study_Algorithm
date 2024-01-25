package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Boj_19941_햄버거_분배 {
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int start=0;
		int end=0;
		int answer=0;
		String ph = br.readLine();
		boolean isH[] = new boolean[n];
		for(int i=0; i<n;i++) {
			if(ph.charAt(i) == 'H') isH[i] =true; 
		}
		for(int i=0; i<n; i++) {
			if(ph.charAt(i) == 'P') {
				if(i-k < 0) start=0;
				else start = i-k;
				if(i+k > n) end = n;
				else end =i+k+1;
				for(int j=start; j<end; j++) {
					if(isH[j]) {
						System.out.println(i+"번이 "+j+"번 버거");
						answer++;
						isH[j] = false;
						break;
					}
				}
			}
		}
		bw.append(answer+"");
		bw.flush();
		bw.close();
		br.close();
	}
	

}