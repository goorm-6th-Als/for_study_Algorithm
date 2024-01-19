package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 코테1회차_2번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long size = Long.parseLong(br.readLine());
        long sum = 0;
        long numSize =0;
        while(sum<=size){
            numSize++;
            sum+=numSize;
        }

        if(sum == size){
            System.out.println(numSize);
        }else{
            System.out.println(numSize-1);
        }
    }
}
