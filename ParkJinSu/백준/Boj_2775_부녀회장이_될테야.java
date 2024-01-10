package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Boj_2775_부녀회장이_될테야 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int[][] apart;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		apart = new int[15][15];
		for(int i=0; i<t; i++) {
			bw.append(fn(Integer.parseInt(br.readLine())+1,Integer.parseInt(br.readLine())) +"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int fn(int f, int n) {
		//System.out.println("f = " +f +"\n n = " +n);
		if(apart[f][n] > 0){
			return apart[f][n];
					
			}
		if(f == 0 || n == 1) {
			return apart[f][n]=1;
		}
		return apart[f][n] = fn(f,n-1) + fn(f-1,n); 
	}
	

}