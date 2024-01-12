package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10870_피보나치수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(fin(num));
    }

    public static int fin(int num){
        if(num == 0){
            return 0;
        }
        if(num == 1){
            return 1;
        }
        return fin(num-1) + fin(num-2);
    }
}
