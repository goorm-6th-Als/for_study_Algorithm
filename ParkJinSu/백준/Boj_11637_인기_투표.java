package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Boj_11637_인기_투표 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n,cnt,winner,total;
		int arr[];
		int max;
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i<t; i++) {
			max = 0;
			total = 0;
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			cnt=0;
			winner=0;
			for(int j=0; j<n; j++) {
				arr[j] = Integer.parseInt(br.readLine());
				max = Math.max(arr[j], max);
				total +=arr[j];
			}
			for(int j=0; j<n; j++) {
				if(arr[j] == max) {
					cnt++;
					winner = j;
				}
			}
			winner++;
			if(cnt >1) bw.append("no winner\n");
			else if(total-max < max) bw.append("majority winner "+ winner+"\n");
			else bw.append("minority winner " + winner+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}