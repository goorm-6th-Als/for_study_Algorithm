package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.net.ssl.SSLContext;
public class Boj_16953_AtoB {
	
	static boolean graph[];
	static int b;
	static Queue<Integer> q;
	static int answer = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//int n = Integer.parseInt(br.readLine());
		q = new LinkedList<Integer>();
		int a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		graph = new boolean[1000000001];
		bfs(a,1);
		bw.append(""+answer);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(long start,int cnt) {
		if(start == b) {
			if(answer == -1) answer = cnt;
			else answer = Math.min(answer, cnt);
			return;
		}
		if(start>= b || graph[(int)start]) return;
		q.add((int)start);
		graph[(int)start] = true;
		cnt++;
		while(!q.isEmpty()) {
			long index =q.poll();
			bfs(start*2, cnt);
			bfs((start*10)+1, cnt);
		}
		
		
	}
	
}