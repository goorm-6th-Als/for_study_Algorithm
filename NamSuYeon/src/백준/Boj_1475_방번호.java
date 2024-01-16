package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] isChecked = new int[10];
        String[] number = br.readLine().split("");
        int max = 0;

        for(int i = 0; i<number.length; i++){
            isChecked[Integer.parseInt(number[i])] +=1;
            max = Math.max(max,isChecked[Integer.parseInt(number[i])]);
        }

        if (max == isChecked[6] || max == isChecked[9]){
            max = (int)Math.ceil((isChecked[6] + isChecked[9])/2);
            isChecked[6] = max;
            isChecked[9] = max;
        }

        for(int i = 0; i<isChecked.length; i++){
            max = Math.max(max, isChecked[i]);
        }

        System.out.println(max);
    }
}
