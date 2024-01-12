package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Boj_2750_수_정렬하기 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] sort = new int[n];
		for(int i=0; i<n; i++) {
			sort[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(sort);
		for(int i=0;i<n; i++) {
			bw.append(sort[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}