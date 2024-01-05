import java.util.*;
import java.io.*;

public class Main { // 1110번 더하기 사이클
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int first, second, temp, next = -1;
		int answer = 0;

		while(next != N) {
			if(answer == 0) {
				next = N;
			}

			first = next / 10;
			second = next % 10;
			temp = first + second;
			next = second * 10 + temp % 10;
			answer++;
		}

		System.out.println(answer);
	}
}
