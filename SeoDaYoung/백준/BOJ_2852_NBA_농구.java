import java.io.*;
import java.util.*;

public class BOJ_2852_NBA_농구 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int s = 0; // 이기고 있는 팀
        int time = 0; // 전 타임 골 넣은 시간
        int ntime = 0; // 현재 골 넣은 시간
        int t_a = 0; // 1팀 시간
        int t_b = 0; // 2팀 시간
        boolean chk;

        int i = 0;
        while (i < N) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")) {
                chk = true;
            } else {
                chk = false;
            }

            String str = st.nextToken();
            ntime = (str.charAt(0) - '0') * 600;
            ntime += (str.charAt(1) - '0') * 60;
            ntime += (str.charAt(3) - '0') * 10;
            ntime += (str.charAt(4) - '0');

            if (s > 0) {
                t_a += ntime - time;
            }
            if (s < 0) {
                t_b += ntime - time;
            }

            if (chk) {
                s += 1;
            } else {
                s -= 1;
            }
            time = ntime;
            i++;
        }
        if (s > 0)
            t_a += 2880 - time;
        if (s < 0)
            t_b += 2880 - time;

        System.out.format("%02d:%02d\n", t_a / 60, t_a % 60);
        System.out.format("%02d:%02d\n", t_b / 60, t_b % 60);
    }
}
