package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_19942_햄버거분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int lengthOfHambuger = Integer.parseInt(st.nextToken());
        String[] input = br.readLine().split("");
        boolean[] isChecked = new boolean[K];
        int count = 0;

        for(int i = 0; i<K; i++){
            if(!input[i].equals("P")){
                continue;
            }
            int start = i -lengthOfHambuger;
            int end = i + lengthOfHambuger;
            for (int j = start; j<=end; j++){
                if(0<= j && j < input.length && input[j].equals("H") && !isChecked[j]){
                    isChecked[j] = true;
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
