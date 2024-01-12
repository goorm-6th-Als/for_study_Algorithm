package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_1789_수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long input = Long.parseLong(br.readLine());
        long sum = 0;
        List<Long> numList = new ArrayList<>();
        for(long i = 1; i<input+1; i++){
            if(sum <input ){
                sum+=i;
                numList.add(i);
            }
        }

        while (input != sum){
            if(input <sum){
                sum -= numList.remove(numList.size()/2-1);
            }else{
                long lastNum = numList.get(numList.size()-1)+1;
                sum += lastNum;
                numList.add(lastNum);
            }
        }
        System.out.println(numList.get(numList.size()-1));
    }
}
