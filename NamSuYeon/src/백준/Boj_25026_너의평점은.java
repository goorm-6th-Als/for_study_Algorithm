package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_25026_너의평점은 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String[]> input = new ArrayList<>();
        int removeSize = 0;
        float sum = 0;
        float creditOfSum = 0;

        for(int i = 0; i<20; i++){
            input.add(br.readLine().split(" "));
        }

        for(int i = 0; i<input.size(); i++){
            if(input.get(i)[2].equals("P")){
                removeSize++;
                continue;
            }
            sum += Float.parseFloat(input.get(i)[1]) * calculateTest(input.get(i)[2]);
            creditOfSum += Float.parseFloat(input.get(i)[1]);
        }
        System.out.println(sum/creditOfSum);
    }

    public static float calculateTest(String letter){
        if(letter.equals("A+")){
            return 4.5f;
        } else if (letter.equals("A0")) {
            return 4.0f;
        } else if (letter.equals("B+")) {
            return 3.5f;
        } else if (letter.equals("B0")) {
            return 3.0f;
        }else if (letter.equals("C+")) {
            return 2.5f;
        } else if (letter.equals("C0")) {
            return 2.0f;
        } else if (letter.equals("D+")) {
            return 1.5f;
        }else if (letter.equals("D0")){
            return 1.0f;
        }else{
            return 0.0f;
        }
    }
}
