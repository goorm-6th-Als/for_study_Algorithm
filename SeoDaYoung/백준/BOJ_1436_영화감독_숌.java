import java.io.*;

public class BOJ_1436_영화감독_숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int num = 666; // 시작 수
        int cnt = 1; // n번째 수

        while (cnt != n) {
            num++;

            if (Integer.toString(num).contains("666")) {
                cnt++;
            }
        }
        System.out.println(num);
    }
}
