package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2335_부녀회장이될테야 {
    static int[][] apart = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        for(int i = 1; i<15; i++){
            apart[0][i] = i;
        }

        for(int i = 0; i<size; i++){
            int low = Integer.parseInt(br.readLine());
            int column = Integer.parseInt(br.readLine());

            System.out.println(dfs(low,column));
        }
    }

    private static int dfs(int low, int column) {
        int sum = 0;
        for(int i = 1; i<=column; i++){
            if(apart[low-1][i] == 0){
                apart[low-1][i] = dfs(low-1,i);
            }
            sum+=apart[low-1][i];
        }
        return sum;
    }
}
