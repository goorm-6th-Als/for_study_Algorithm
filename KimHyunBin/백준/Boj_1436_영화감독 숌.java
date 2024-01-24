import java.util.*;
import java.io.*;

public class Main {
	public static int N = 10;
	public static String s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int chk = 1;
		int answer = 666;
		// 666, 1666, 2666, 3666, 4666, 5666, 6661, 6662, 6663, 6664, 6665
		// 6666 ... 9666 -> 10000 이하이므로 걍 다 따져줌
		
		while(chk != N) {
			answer ++;
			s = answer + "";
			if(s.contains("666")){
				chk ++;
			}
		}
		System.out.println(answer);
	}
}