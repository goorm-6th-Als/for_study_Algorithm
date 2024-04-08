import java.io.*;
import java.util.*;

public class BOJ_8979_올림픽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][4];

        int endPoint = 0; // k의 배열 내 위치 저장
        int rank = 0; // 높은 순위의 국가 수

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 람다다! 값을 비교해 오름차순 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                if (o1[2] == o2[2]) {
                    return Integer.compare(o1[3], o2[3]);
                }
                return Integer.compare(o1[2], o2[2]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        // k의 인덱스 위치 찾기
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == k) {
                endPoint = i;
                break;
            }
        }

        // 배열 끝에서 앞으로 순회
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i][1] == arr[endPoint][1] && // 현재 순회 중인 국가 = K 국가
                    arr[i][2] == arr[endPoint][2] &&
                    arr[i][3] == arr[endPoint][3]) {
                break;
            } else { // 현재 순회 중인 국가 > K 국가
                rank++;
            }
        }
        System.out.println(rank + 1);
    }
}