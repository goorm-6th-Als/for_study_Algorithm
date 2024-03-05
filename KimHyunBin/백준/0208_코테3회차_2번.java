import java.util.*;
import java.io.*;

public class Main { // Boj_1436_영화감독 숌
	public static int N = 10;
	public static String s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int answer = 666;
		int chk = 1;		
		while(chk != N) {
			answer += 1;
			s = String.valueOf(answer);
			if(s.contains("666")){
				chk += 1;
			}
		}
		System.out.println(answer);
	}
}