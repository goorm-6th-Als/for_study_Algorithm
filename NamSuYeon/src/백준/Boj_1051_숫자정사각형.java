package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1051_숫자정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int[][] graph = new int[row][column];
        int answer = 0;

        for(int i = 0; i<row; i++){
            String[] s = br.readLine().split("");
            for(int j = 0; j<column; j++){
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i = 0; i<row; i++){
            for(int j = 0; j<column; j++){
                int isCheckedNum = graph[i][j];
                for(int z = 1; z<Math.min(row, column); z++){
                    if(i+z >= row || j+z >=column){
                        break;
                    }

                    if(graph[i][j+z] == isCheckedNum && graph[i+z][j] ==isCheckedNum && graph[i+z][j+z] == isCheckedNum){
                        if(answer <  (z+1)*(z+1)){
                            answer = (z + 1) * (z + 1);
                        }
                    }
                }
            }
        }
        if(answer == 0){
            System.out.println(1);
        }else{
            System.out.println(answer);
        }

    }
}
