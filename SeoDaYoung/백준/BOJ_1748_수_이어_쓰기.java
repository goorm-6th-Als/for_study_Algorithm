import java.io.*;

public class BOJ_1748_수_이어_쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0; 
        int plus = 1; 
        int num = 10;

        for (int i=1; i<=n; i++) {
            if (i % num == 0) {
                plus++;
                num *= 10; // 자릿수 바뀌는 조건 (10, 100, 1000...etc)
            }
            count += plus;
        }
        System.out.println(count);
    }
}
