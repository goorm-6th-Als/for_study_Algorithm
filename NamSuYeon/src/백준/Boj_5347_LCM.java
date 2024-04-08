package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

public class Boj_5347_LCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());



        for(int i = 0; i<size; i++){
            HashSet<Integer> number = new HashSet<>();
            String[] str = br.readLine().split(" ");
            int sum = 1;
            int leftNum = Integer.parseInt(str[0]);
            int rightNum = Integer.parseInt(str[1]);

            for(int j = 2; j < leftNum/2; j++){
                if(leftNum % j == 0){
                    number.add(j);
                    number.add(leftNum/j);
                }
            }
            for(int j = 2; j < rightNum/2; j++){
                if(rightNum % j == 0){
                    number.add(j);
                    number.add(rightNum/j);
                }
            }
            Iterator<Integer> result = number.iterator();
            while(result.hasNext()){
                sum *= result.next();
            }
            System.out.println(sum);
        }

    }
}
