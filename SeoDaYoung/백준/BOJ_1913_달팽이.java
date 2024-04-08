import java.io.*;
import java.util.*;

public class BOJ_1913_달팽이 {
    static int N, A;
    static int[][] arr;

    // 주어진 달팽이 움직임과 거꾸로 배열 요소 삽입
    static int[] dx = { 1, 0, -1, 0 }; // (하 -> 우 -> 상 -> 좌) 순
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        A = Integer.parseInt(br.readLine());

        arr = new int[N][N]; // 출력할 배열
        int idx = 0;

        // 시작 좌표
        int curX = 0;
        int curY = 0;
        
        arr[curX][curY] = N * N;

        while (idx < 4) {
            int nx = curX + dx[idx];
            int ny = curY + dy[idx];

            // 다음 좌표가 범위 안이고 아직 수를 넣지 않은 위치라면
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 0) {

                // 이전 좌표에 있던 수보다 1 작은 값 삽입
                arr[nx][ny] = arr[curX][curY] - 1;

                // 종료 조건
                if (arr[nx][ny] == 1)
                    break;

                // 다음 좌표를 찾기 위해 값 갱신
                curX = nx;
                curY = ny;

            } else {
                idx++; // 다음 좌표가 범위를 벗어났거나 이미 수를 넣은 좌표라면 idx + 1
            }
            if (idx >= 4) {
                idx = 0;
            }
        }
            int ansX = 0, ansY = 0; // 찾아야 하는 수의 좌표 변수

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {

                    if (arr[i][j] == A) {
                        ansX = i+1;
                        ansY = j+1;
                    }
                    sb.append(arr[i][j] + " ");
                }
                sb. append("\n");
            }
            sb.append(ansX + " " + ansY);

            System.out.println(sb);
    }
}
