import java.io.*;
import java.util.Arrays;

public class Main {
    static Long[] mem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        mem = new Long[N+2];

        mem[0]= 0L;
        mem[1]= 1L;
        mem[2] =3L;

        System.out.println(dp(N));

    }

    static long dp(int n){
   //     System.out.println(Arrays.toString(mem));

        if(mem[n]==null){
            mem[n] = (dp(n-1) + 2*dp(n-2))%10007;
        }

        return mem[n];
    }

}