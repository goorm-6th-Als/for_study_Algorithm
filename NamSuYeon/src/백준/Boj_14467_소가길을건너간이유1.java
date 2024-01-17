package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14467_소가길을건너간이유1 {
    public static void main(String[] args) throws IOException {
        // 1 true 2 false
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cowSize = Integer.parseInt(br.readLine());
        int[] isCheckedLoc = new int[11];
        int[] isCheckedMoveSize = new int[11];
        int cowMoveCount = 0;

        for(int i = 0; i<cowSize; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cowNum = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            if(isCheckedMoveSize[cowNum]++ >0 && isCheckedLoc[cowNum] != loc){
                cowMoveCount+=1;
                isCheckedLoc[cowNum] = loc;
            }else{
                isCheckedMoveSize[cowNum] = 1;
                isCheckedLoc[cowNum] = loc;
            }
        }

        System.out.println(cowMoveCount);
    }
}
