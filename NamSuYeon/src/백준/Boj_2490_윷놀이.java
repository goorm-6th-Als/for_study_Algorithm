package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2490_윷놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] input = new String[3][4];
        int[] result = new int[3];

        for(int i = 0; i<3; i++){
            input[i] = br.readLine().split(" ");
        }

        for(int i = 0; i<3; i++){
            int size = 0;
            for(int j = 0; j< input[i].length; j++){
                if(input[i][j].equals("0")){
                    size++;
                }
            }
            result[i] = size;
        }

        for(int i = 0; i<result.length; i++){
            if(result[i] == 0){
                System.out.println("E");
            } else if (result[i] == 1) {
                System.out.println("A");
            } else if (result[i] == 2) {
                System.out.println("B");
            } else if (result[i] == 3) {
                System.out.println("C");
            } else if (result[i] == 4) {
                System.out.println("D");
            }
        }
    }
}
