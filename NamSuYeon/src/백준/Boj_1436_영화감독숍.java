package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1436_영화감독숍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int number = 0;
        int i = 0;

        while(true){

            if(String.valueOf(i).contains("666")){
                number +=1;
            }
            if(number == size ){
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}
