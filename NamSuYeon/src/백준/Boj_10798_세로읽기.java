package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_10798_세로읽기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String[]> result = new ArrayList<>();
        int length = 0;
        StringBuilder output = new StringBuilder();

        for(int i = 0; i<5; i++){
            String[] tmp = br.readLine().split("");

            if(length < tmp.length){
                length = tmp.length;
            }
            result.add(tmp);
        }

        for(int i = 0; i<length; i++){
            for(int j = 0; j<5; j++){
                if(result.get(j).length > i){
                    output.append(result.get(j)[i]);
                }
            }
        }
        System.out.println(output.toString());
    }


}
