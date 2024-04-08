import java.io.*;

public class 코테3회차_1번 { // BOH_1748_수_이어_쓰기_1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = 10;
        int plus = 1;
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (i % num == 0) {
                plus++;
                num*=10;
            }
            cnt += plus;
        }
        System.out.println(cnt);
    }
}
