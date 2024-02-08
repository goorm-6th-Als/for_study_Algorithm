package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2583_영역_구하기 {
	static boolean[][] paper;
	static int count,paperY,paperX;
	static int x,y;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startX, endX, startY, endY;
		paperY = Integer.parseInt(st.nextToken());
		paperX = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		paper = new boolean[paperY][paperX];
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			startX =Integer.parseInt(st.nextToken());
			startY =Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			for(int x=startX; x<endX; x++) {
				for(int y=startY; y<endY; y++) {
					paper[y][x] = true;
				}
			}
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int y=0; y<paperY; y++) {
			for(int x=0; x<paperX; x++) {
				if(!paper[y][x]) {
					count=0;
					dfs(y,x);
					arr.add(count);
				}
			}
		}
		Collections.sort(arr);
		bw.append(arr.size()+"\n");
		for(int i=0; i<arr.size(); i++) {
			bw.append(arr.get(i) +" ");
		}
		bw.flush();
		bw.close();
		br.close();

	}
	
	static void dfs(int inputY, int inputX) {
		paper[inputY][inputX] = true;
		count++;
		
		for(int i=0; i<4; i++) {
			x = inputX - dx[i];
			y = inputY - dy[i];
			if(check(x,y) && !paper[y][x]) {
				dfs(y,x);
			}
		}
	}
	
	static boolean check(int x, int y) {
		if(x>=0 && x<paperX && y>=0 && y<paperY) return true;
		
		return false;
	}
	
}