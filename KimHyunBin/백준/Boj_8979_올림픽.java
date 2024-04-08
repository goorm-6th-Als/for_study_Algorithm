import java.io.*;
import java.util.*;

public class Main { // Boj_8979_올림픽
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            arr[i][0] = country;
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, new Comparator<int[]>() { // 금은동 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                } else if (o1[2] != o2[2]) {
                    return o2[2] - o1[2];
                } else {
                    return o2[3] - o1[3];
                }
            }
        });

        int rank = 1;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            if (i > 0 && (arr[i][1] != arr[i-1][1] || arr[i][2] != arr[i-1][2] || arr[i][3] != arr[i-1][3])) {
                rank += cnt;
                cnt = 1;
            } else if (i > 0) {
                cnt++;
            }

            if (arr[i][0] == K) {
                System.out.println(rank);
                break;
            }
        }
    }
}