import java.util.*;
import java.io.*;

public class Main {// Boj_14467_소가 길을 건너간 이유 1

	static int N,answer;
	static int [] cow, cow_cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		cow = new int [10+1];
		answer = 0;
		Arrays.fill(cow, -1);
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cow_num = Integer.parseInt(st.nextToken());
			int location = Integer.parseInt(st.nextToken());
			if(cow[cow_num] == -1) {
				cow[cow_num] = location;
			}else if(cow[cow_num] != location) {
				cow[cow_num] = location;
				answer ++;
			}
			
		}
		
		System.out.println(answer);

	}
}