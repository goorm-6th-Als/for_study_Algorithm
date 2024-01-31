import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main { // Boj_2852_NBA 농구
    public static int Time_mm_1, Time_ss_1, Time_mm_2, Time_ss_2;
    public static int N, point_1, point_2, before_mm, before_ss;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        point_1 = point_2 = 0;
        Time_mm_1 = Time_ss_1 = Time_mm_2 = Time_ss_2 = 0;
        before_mm = before_ss = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String[] time = st.nextToken().split(":");

            int mm = Integer.parseInt(time[0]);
            int ss = Integer.parseInt(time[1]);

            if (k == 1) { // 1팀일때
                if (point_1 == point_2) { // 동점이었다면 
                    before_mm = mm;
                    before_ss = ss;
                }
                point_1++;
                if (point_1 == point_2) { // 1이 지고있었다면
                    updateTime(2, mm, ss);
                }
            } else if(k == 2){ // 2팀일때
                if (point_1 == point_2) { // 동점이었다면 
                    before_mm = mm;
                    before_ss = ss;
                }
                point_2++;
                if (point_1 == point_2) { // 2가 지고있었다면
                    updateTime(1, mm, ss);
                }
            }
        }

        finalizeTime(point_1, point_2);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d:%02d\n", Time_mm_1, Time_ss_1));
        sb.append(String.format("%02d:%02d\n", Time_mm_2, Time_ss_2));
        System.out.print(sb.toString());
    }

    private static void updateTime(int team, int mm, int ss) {
        if (team == 1) {
            if (ss >= before_ss) {
                Time_mm_1 += mm - before_mm;
                Time_ss_1 += ss - before_ss;
            } else { // -15초 -> -1분 + 45초
                Time_mm_1 += mm - before_mm - 1;
                Time_ss_1 += ss - before_ss + 60;
            }
        } else {
            if (ss >= before_ss) {
                Time_mm_2 += mm - before_mm;
                Time_ss_2 += ss - before_ss;
            } else {
                Time_mm_2 += mm - before_mm - 1;
                Time_ss_2 += ss - before_ss + 60;
            }
        }
    }

    private static void finalizeTime(int score1, int score2) {
        if (score1 > score2) { // 1이 마지막 골 이후로 골이 많았다면
            Time_mm_1 += 47 - before_mm; 
            Time_ss_1 += 60 - before_ss;
        } else if (score2 > score1) {
            Time_mm_2 += 47 - before_mm;
            Time_ss_2 += 60 - before_ss;
        }

        normalizeTime();
    }

    private static void normalizeTime() {
        Time_mm_1 += Time_ss_1 / 60;
        Time_ss_1 %= 60;
        Time_mm_2 += Time_ss_2 / 60;
        Time_ss_2 %= 60;
    }
}
