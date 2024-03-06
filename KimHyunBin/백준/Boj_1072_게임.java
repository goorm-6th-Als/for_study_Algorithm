import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // Boj_1072_게임
    public static int[] arr_A, arr_B;
    public static long X, Y, Z, answer;

    // X = 게임 횟수 -> 이긴 게임 + 진게임
    // Y = 이긴 게임, Z -> Y/X 소수점은 버린다.
    // Z 가 변할 수 있는 최소한의 게임 수, 모든 게임은 이긴다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        answer = -1;
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = (Y * 100) / X ;

        if (Z >= 99) {
            System.out.println("-1");
        } else {
            long low = 1;
            long high = X; // 맞네.. 게임 수 범위에서 찾아야함 Y 가 아님.
            long mid = 0;
            long now = 0;

            while (low <= high) {
                mid = (low + high) / 2;
                now = (Y + mid) * 100 / (X + mid);
                // 변경값이 커진다면 answer 갱신
                // high 줄이면서 최소값 찾기.
                if (now > Z) {
                    answer = mid;
                    high = mid - 1;
                } else if( now <= Z){
                    low = mid + 1;
                }

            }
            System.out.println(answer);
        }
    }

}