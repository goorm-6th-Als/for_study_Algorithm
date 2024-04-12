import java.io.*;
import java.util.*;

public class Main { // Boj_4892_숫자 맞추기

    static int N, M, answer, start_x, start_y, shark_Size, time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {

            if (n % 2 == 0) {
                n = (((n * 3) / 2) * 3) / 9;
                sb.append(idx).append(". even ").append(n).append("\n");
            } else {
                n = ((((n * 3) + 1) / 2) * 3) / 9;
                sb.append(idx).append(". odd ").append(n).append("\n");
            }
            idx++;
        }
        System.out.println(sb);
    }
}