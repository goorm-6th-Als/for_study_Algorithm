package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_2750_수정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Integer> array = new ArrayList<>();

        for(int i = 0; i<size; i++){
            array.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(array);

        for(int i = 0; i<array.size(); i++){
            System.out.println(array.get(i));
        }

    }
}
