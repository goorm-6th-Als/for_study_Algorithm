package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_2002_추월 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<String> cars = new ArrayList<>();
        int count = 0;

        for(int i = 0; i<size; i++){
            cars.add(br.readLine());
        }

        int i = 0;
        int j = 0;

        while(j<size){
            String input = br.readLine();
            if(!cars.get(i).equals(input)){
                count++;
                cars.remove(input);
            }else{
                i++;
            }
            j++;
        }

        System.out.println(count);

    }
}
