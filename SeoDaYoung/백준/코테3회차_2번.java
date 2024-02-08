import java.io.*;

public class 코테3회차_2번 { // BOJ_1436_영화감독_숌
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int num = 666;
        int cnt = 1;
        
        while (cnt != n) {
            num++;

            if (Integer.toString(num).contains("666")) {
                cnt++;
            }
        }
        System.out.println(num);
    }
}