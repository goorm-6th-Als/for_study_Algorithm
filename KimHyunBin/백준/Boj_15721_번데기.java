import java.util.*;
import java.io.*;

public class Main {// Boj_15721_번데기
	// 큐로 구현, 완전 탐색 input 10000이므로
	static int answer, T, B, time_bb, time_dg;
	static Queue<Integer> que;
	static int[] action;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());// 사람 수
		T = Integer.parseInt(br.readLine());// T번째 뻔, 데기
		B = Integer.parseInt(br.readLine());// 0 -> 뻔, 1-> 데기
		action = new int[A];
		que = new LinkedList<>();

		answer = 0; time_bb = 0; time_dg = 0;
		for (int i = 0; i < A; i++) {
			que.add(i);
		}

		game();

		System.out.println(answer);

	}

	public static void game() {
		int idx = 2;
		loop1: while (true) { // 회차
			int temp = 0;
			
			for (int i = 0; i < 2; i++) { // 뻔 데기 * 2
				temp = cycle();
//				System.out.println("뻔 ");
				time_bb++;
				if(chk()) {
					answer = temp;
					break loop1;
				}
				temp = cycle();
//				System.out.println("데기 ");
				time_dg++;
				if(chk()) {
					answer = temp;
					break loop1;
				}
			}

			for (int i = 0; i < idx; i++) { // 뻔 * n
				temp = cycle();
//				System.out.println("뻔 반복 ");
				time_bb++;
				if(chk()) {
					answer = temp;
					break loop1;
				}
			}
			for (int i = 0; i < idx; i++) { // 데기 * n
				temp = cycle();
//				System.out.println("데기 반복");
				time_dg++;
				if(chk()) {
					answer = temp;
					break loop1;
				}
			}
			idx ++;
//			System.out.println("회차 :" + (idx-1));
		}
		return;
	}

	public static int cycle() { // 순환하도록
		int front = que.poll();
		que.add(front);
//		System.out.printf(front +"번째 사람 차례 ");
		return front;
	}
	
	public static boolean chk() { // 뻔, 데기 구분
		if(B == 0 && T == time_bb) {
			System.out.println("---뻔 " + time_bb+"번째");
			return true;
		}
		if(B == 1 && T == time_dg) {
			System.out.println("---데기 " + time_dg+"번째");
			return true;
		}
		return false;
	}
}