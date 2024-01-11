package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2563_색종이 {
    public static void main(String[] args) throws IOException {
        boolean[][] colorPaper = new boolean[101][101];
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        for(int i = 0; i<size; i++){
            String[] input = br.readLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            for(int y=Y; y<Y+10; y++){
                for(int x=X; x<X+10; x++){
                    colorPaper[y][x] = true;
                }
            }
        }

        for(int i = 0; i<colorPaper.length; i++){
            for(int j = 0; j< colorPaper.length; j++){
                if(colorPaper[i][j]){
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
