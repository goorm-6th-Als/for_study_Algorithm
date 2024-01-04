package baekjoon;

import java.io.*;

public class Boj_2581_소수 {
//에라토스테네스의 체
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int sum =0;
		boolean sosu[] = new boolean[n+1];
		
		sosu[1] = true;
		for(int i=2; i<n; i++) {
			if(!sosu[i]) {
				for(int j=2; j*i<sosu.length; j++) {
					sosu[i*j] = true;
				}
			}
		}
		for(int i=m; i<=n; i++) {
			if(!sosu[i]) sum+=i;
		}
		if(sum == 0) {
			bw.append("-1");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		bw.append(sum+"\n");
		for(int i=m; i<=n; i++) {
			if(!sosu[i]) {
				bw.append(i+"");
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
}
