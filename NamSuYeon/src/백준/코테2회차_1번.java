package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 코테2회차_1번 {
    static boolean[][] whitePage = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i< size; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            attachColorPage(x,y);
        }

        int count = 0;
        for(int i = 0; i< whitePage.length; i++){
            for(int j = 0; j<whitePage.length; j++){
                if(whitePage[i][j]){
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    private static void attachColorPage(int x, int y) {
        for(int i = 0+y; i<10+y; i++){
            for(int j = 0+x; j<10+x; j++){
                whitePage[i][j] = true;
            }
        }
    }


}
