package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_20546_기적의_매매법 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int budget =Integer.parseInt(br.readLine());
		int md[] = new int[14];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<14; i++) {
			md[i] = Integer.parseInt(st.nextToken());
		}
			
		int nbp = nbp(budget,md);
		int timing = timing(budget,md);
		
		if(nbp > timing) bw.append("BNP");
		else if(nbp < timing) bw.append("TIMING");
		else bw.append("SAMESAME");
		
		bw.append("");
		bw.close();
		br.close();
		
		
	}
	
	static int nbp(int budget, int[] md) {
		int cnt=0;
		for(int i=0;i<14;i++) {
			if(budget >= md[i]) {
				cnt += budget/md[i];
				budget = budget%md[i];
			}
		}
		return budget + (cnt * md[13]);
	}
	
	static int timing(int budget, int[] md) {
		int cnt=0;
		int upDay=1;
		int downDay=0;
		for(int i=1;i<14;i++) {
			if(md[i]>md[i-1]) upDay++;
			else upDay =0;
			
			if(md[i]<md[i-1]) downDay++;
			else downDay=0;
			
			
			if(upDay == 3) {
				budget += md[i] * cnt;
				cnt=0;
			}else if(downDay>2) {
				cnt += budget/md[i];
				budget = budget%md[i];
			}
		}
		return budget + (cnt * md[13]);
	}
}
