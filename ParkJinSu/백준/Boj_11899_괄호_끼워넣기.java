package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_11899_괄호_끼워넣기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer =0;
		Stack<Character> stack = new Stack<Character>();
		int right =0;
		String s = st.nextToken();
		int sLen = s.length();
		
		for(int i=0; i<sLen; i++) {
			stack.add(s.charAt(i));
		}
		for(int i=0; i<sLen; i++) {
			if(stack.pop() == ')') {
				right++;
			}else {
				if(right>0) right--;
				else answer++;
			}
		}
		answer += right;
		
		bw.append(answer + "");
		bw.close();
		br.close();

	}

}