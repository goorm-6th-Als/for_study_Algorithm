package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class Boj_2309_일곱_난쟁이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int dwarf[] =new int[9];
		int answer[] = new int[7];
		int total = 0, cnt = 0;
		for(int i =0; i<9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			total += dwarf[i];
		}
		loop:for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				
				if(total - (dwarf[i] + dwarf[j])  == 100) {
					
					for(int k=0; k<9; k++) {
						if(k == i || k == j) continue;
						answer[cnt++] = dwarf[k];
					}
				break loop;
				}
			}
		}
		Arrays.sort(answer);
		for(int i : answer) {
			bw.append(i+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}