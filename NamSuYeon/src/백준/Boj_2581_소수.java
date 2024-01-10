package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2581_소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = Integer.MAX_VALUE;
        boolean isChecked = true;

        for(int i = start; i<=end; i++){
            for(int j = 2; j < i/2; j++){
                if(i % j == 0){
                    isChecked = false;
                    break;
                }
            }
            if(isChecked){
                sum+=i;
                if(min > i){
                    min = i;
                }
            }
            isChecked = true;
        }
        if(sum == 0){
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.println(min);
        }

    }
}
