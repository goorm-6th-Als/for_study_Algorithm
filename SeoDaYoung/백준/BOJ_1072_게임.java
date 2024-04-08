import java.io.*;
import java.util.*;

public class BOJ_1072_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken()); // 총 게임 수
        long Y = Long.parseLong(st.nextToken()); // 이긴 게임 수

        // 승률 = 100 * 이긴 게임 수 / 총 게임 수
        int Z = (int) (100 * Y / X);

        if (Z >= 99) {
            System.out.println("-1");
        } else {
            long min = 0;
            long max = X; // 필요한 추가 게임 수는 X 값을 초과할 수 없음!

            while (min <= max) {
                long mid = (min + max) / 2; // 추가로 이길 필요가 있는 게임 수

                if (Z < 100 * (Y + mid) / (X + mid)) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            System.out.println(min);
        }
    }
}
