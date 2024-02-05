import java.io.*;
import java.util.*;

public class Main { // Boj_9012_괄호
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int input = 0; input < N; input++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') {
                    stack.push(c);
                } else { // c == ')'
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(c);
                        break;
                    }
                }
            }
			if (!stack.isEmpty()) {
				sb.append("NO" + "\n");
			} else {
				sb.append("YES" + "\n");
			}
		}
		System.out.println(sb);
	}
}