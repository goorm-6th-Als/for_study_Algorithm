package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_9012_괄호{

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int front=0, rear=0;
		int n = Integer.parseInt(br.readLine());
		
		
		for(int i =0; i<n; i++) {
			
			bw.append(vps(br.readLine())+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static String vps(String str) {
		Stack<String> st = new Stack<String>();	
		for(int i=0; i<str.length();i++) {
			if(str.charAt(i) == '(') st.push("(");
			else {
				if(st.empty()) {
					return "NO";
				}
				st.pop();
			}
		}
		
		if(st.empty()) return "YES";
		
		return "NO";
		
	}

}