package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1920_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int fistSize = Integer.parseInt(br.readLine());
        int[] input = new int[fistSize];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<fistSize; i++){
            input[i] = (Integer.parseInt(st.nextToken()));
        }

        int secondSize = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int [] isCheckedNum = new int[secondSize];
        for(int i = 0; i<secondSize; i++){
            isCheckedNum[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<secondSize; i++){
            boolean isChecked = false;
            for(int j = 0; j<fistSize; j++){
                if(input[j] == isCheckedNum[i]){
                    isChecked = true;
                    break;
                }
            }
            if(isChecked){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}
