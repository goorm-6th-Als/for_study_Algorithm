import java.util.*;
import java.io.*;

public class Main {// Boj_1969_DNA
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[] alpha = {'A','C','G','T'};
        int[][] chk = new int[M][4];
        int HD = N*M;

        // 자리 별 ATGC 빈도가 높은 애들로 문자열을 만들어 주어야하고 
        // HD는 전체 문자 수 에서 각 자리 빈도를 빼준다.
        
        for (int i = 0; i < N; i++) {
            String DNA = br.readLine();
            for (int j = 0; j < DNA.length(); j++) {
                char c = DNA.charAt(j);
                if (c == 'A') chk[j][0]++;
                else if (c == 'T') chk[j][3]++;
                else if (c == 'G') chk[j][2]++;
                else if (c == 'C') chk[j][1]++;
            }
        }

        
        for (int i = 0; i < M; i++) {
            int max = 0;
            int maxIdx = 0;
            for (int j = 0; j < 4; j++) {
                if (chk[i][j] > max) {
                    max = chk[i][j];
                    maxIdx = j;
                }
            }
            HD -= max; 
            sb.append(alpha[maxIdx]);
        }

        sb.append("\n").append(HD);
        System.out.println(sb);
    }
}