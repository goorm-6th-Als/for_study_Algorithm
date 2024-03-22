import java.io.*;
import java.util.*;

public class Main { // goorm_1회차 조건 합
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        isPrime(N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2; i <= N; i++) {
            int M = Integer.parseInt(st.nextToken());
            if(prime[i]){
                answer += M;
            }
        }
        System.out.println(answer);
    }

    public static void isPrime(int n) {
        prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for(int i = 2; i * i <= n; i++) {
            if(prime[i]) {
                for(int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}