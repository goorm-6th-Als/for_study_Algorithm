package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1065_한수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int count = 99;

        if( 1 <= size && size<=99){
            System.out.println(size);
            return;
        }

        for(int i = 100; i<=size; i++){
            if(i == 1000){
                break;
            }
            int number = i;
            int firstNum = number %10;
            number = number/10;
            int secondNum = number %10;
            number = number/10;
            int thiredNum = number %10;
            if((secondNum - firstNum) == (thiredNum - secondNum)){
                count++;
            }
        }
        System.out.println(count);

    }
}
