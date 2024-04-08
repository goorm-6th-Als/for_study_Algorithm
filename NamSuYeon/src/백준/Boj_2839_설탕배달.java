package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2839_설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugarWeight = Integer.parseInt(br.readLine());

        int maxFiveSize = sugarWeight/5;
        int remain = sugarWeight%5;

        do{
            if(remain %3 == 0){
                System.out.println(maxFiveSize + (remain/3));
                break;
            }else{
                remain+=5;
                maxFiveSize--;
            }
        }while(maxFiveSize>=0);

        if(maxFiveSize<0){
            System.out.println(-1);
        }

    }
}
