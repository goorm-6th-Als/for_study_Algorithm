package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_14467_소가_길을_건너간_이유1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int cow, position, cnt;
		int[] cowArr = new int[11];
		boolean[] isObservation = new boolean[11];

		StringTokenizer st;
		cnt=0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			cow = Integer.parseInt(st.nextToken());
			position = Integer.parseInt(st.nextToken());
			if(!isObservation[cow]) {
				isObservation[cow] = true;
				cowArr[cow] = position;
			}else if(cowArr[cow] != position){
				cowArr[cow] = position;
				cnt++;
			}
		}
		
		bw.append(cnt+"");
		bw.close();
		br.close();
		
		
	}
}
