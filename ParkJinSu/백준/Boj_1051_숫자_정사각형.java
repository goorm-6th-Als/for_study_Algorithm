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

public class Boj_1051_숫자_정사각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*	3 5
		 * 	42101	422
			22100	222
			22101	111
					000
					101
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String strArr[] = new String[n];
		for (int i = 0; i < n; i++) {
			strArr[i] = br.readLine();
		}
		if (n < m) {
			for (int i = n - 1; i >= 0; i--) { // 크기
				for (int j = 0; j + i < m; j++) {// ->
					for (int k = 0; k + i < n; k++) { // 아래
						if (strArr[k].charAt(j) == strArr[k + i].charAt(j)
								&& strArr[k].charAt(j + i) == strArr[k].charAt(j)
								&& strArr[k + i].charAt(j + i) == strArr[k].charAt(j)) {
							print(((i + 1) * (i + 1)) + "");
							return;
						}
					}
				}
			}
		} else {
			for (int i = m - 1; i >= 0; i--) { // 크기
				for (int k = 0; k + i < n; k++) { // 아래
					for (int j = 0; j + i < m; j++) {// ->
						if (strArr[k].charAt(j) == strArr[k + i].charAt(j)
								&& strArr[k].charAt(j + i) == strArr[k].charAt(j)
								&& strArr[k + i].charAt(j + i) == strArr[k].charAt(j)) {
							print(((i + 1) * (i + 1)) + "");
							return;
						}
					}
				}
			}
		}
		print("1");

		br.close();
	}

	static void print(String msg) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(msg);
		bw.flush();
		bw.close();
	}

}