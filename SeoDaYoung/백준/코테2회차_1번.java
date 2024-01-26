import java.io.*;
import java.util.StringTokenizer;

public class 코테2회차_1번 { // BOJ_2563_색종이
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    boolean[][] arr = new boolean[101][101];

    int total = 0;

    for (int i = 0; i<n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for (int j=x; j<x+10; j++) {
            for (int k=y; k<y+10; k++) {
                if (!arr[j][k]) {
                    arr[j][k] = true;
                    total++;
                }
            }
        }
    }
    System.out.println(total);
    }
}
