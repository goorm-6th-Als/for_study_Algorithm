import java.util.*;
import java.io.*;

public class Main { // 2490_윷놀이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		char[] arr = { 'D', 'C', 'B', 'A', 'E' }; // 윷, 도,개,걸,모
		for (int Tc = 1; Tc <= 3; Tc++) {
			int temp = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				temp += Integer.parseInt(st.nextToken());
			}
			System.out.println(arr[temp]);
		}

	}

}
