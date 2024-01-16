package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Boj_1475_방_번호 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String n = br.readLine();
		
		int max=0;
		int set[] = new int[10];
		for(int i=0; i<n.length(); i++) {
			set[n.charAt(i)-48]++;
		}
			
		
		set[6] = (set[6]+set[9]+1)/2;
		
		for(int i = 0; i<9; i++) {
			max = Math.max(max, set[i]);
		}
		bw.append(max+"");
		bw.flush();
		bw.close();
		br.close();
	}

	
}