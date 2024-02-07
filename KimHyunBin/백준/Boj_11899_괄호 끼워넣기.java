import java.io.*;
import java.util.*;

public class Main { // Boj_11899_괄호 끼워넣기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
//		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);
			if (now == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else {
				stack.push(now);
			}
		}
		answer = stack.size();

		System.out.println(answer);
	}
}