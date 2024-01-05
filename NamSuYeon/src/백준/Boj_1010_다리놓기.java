package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1010_다리놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        for(int i = 0; i<size; i++){
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            System.out.println(Math.round(mix(m,n)/mix(n,n)));

        }

    }

    public static double mix(int num, int size){
        double total = 1;
        for(int i = 0; i<size; i++){
            total *= num -i;
        }
        return total;
    }
}
