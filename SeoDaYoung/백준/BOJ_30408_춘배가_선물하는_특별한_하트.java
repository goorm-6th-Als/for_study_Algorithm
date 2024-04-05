import java.io.*;
import java.util.*;

public class BOJ_30408_춘배가_선물하는_특별한_하트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        Set<Long> set = new HashSet<>();
        set.add(N);

        boolean weight = (N % 2 == 0) ? false : true; // 홀짝 판별

        while (N > 1) {
            if (weight) { // 입력값이 홀수인 경우
                N /= 2;
                Long divWeight = N;
                set.add(divWeight);
                set.add(divWeight + 1);

            } else { // 입력값이 짝수인 경우
                if (N % 2 == 0) {
                    N /= 2;
                    Long divWeight = N;
                    set.add(divWeight);
                } else { // (N % 2 == 1)
                    weight = true;
                    N = (N - 1) / 2;
                    Long divWeight = N;
                    set.add(divWeight);
                    set.add(divWeight + 1);
                }
            }
        }
        if (set.contains(M)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}