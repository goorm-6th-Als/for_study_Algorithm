import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15721_번데기 {

    static int A, T, slogan;
    static int repeat = 2; // repeat 변수를 통해 뻔, 데기가 몇 번 반복해야 하는지 확인
    static int zeroCnt, oneCnt; // 뻔=0, 데기=1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(br.readLine()); // 게임 인원
        T = Integer.parseInt(br.readLine()); // 구하고자 하는 번째
        slogan = Integer.parseInt(br.readLine()); // 구호
        int result = solve();

        System.out.println(result);
    }

    public static int solve() {
        while (true) {
            for (int i = 0; i < 4; i++) { // 뻔-데기-뻔-데기
                if (i % 2 == 0) {
                    zeroCnt++;
                } else {
                    oneCnt++;
                }
                if (slogan == 0 && zeroCnt == T) { // 0의 등장 횟수가 T와 같다면
                    return (zeroCnt + oneCnt - 1) % A;
                    // 0번부터 카운트하기 때문에 -1
                }
                if (slogan == 1 && oneCnt == T) { // 1의 등장 횟수가 T와 같다면
                    return (zeroCnt + oneCnt - 1) % A;
                }
            }

            // 이후 반복되는 뻔xn, 데기xn
            for (int i = 0; i < repeat; i++) {
                zeroCnt++;
                if (slogan == 0 && zeroCnt == T) {
                    return (zeroCnt + oneCnt - 1) % A;
                }
            }
            for (int i = 0; i < repeat; i++) {
                oneCnt++;
                if (slogan == 1 && oneCnt == T) {
                    return (zeroCnt + oneCnt - 1) % A;
                }
            }
            repeat++;
        }
    }
}