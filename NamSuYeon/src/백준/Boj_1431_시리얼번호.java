package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Boj_1431_시리얼번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<String> input = new ArrayList<>();

        for(int i = 0; i<size; i++){
            input.add(br.readLine());
        }

        Collections.sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()){
                    return -1;
                }else if(o1.length() == o2.length()){
                    if(sum(o1) == sum(o2)) {
                        return o1.compareTo(o2);
                    }else{
                        return Integer.compare(sum(o1), sum(o2));
                    }
                }
                return 1;
            }
        });


        for (String s : input) {
            System.out.println("s = " + s);
        }
    }

    static int sum(String s){
        int stringNumber = 0;
        char[] array = s.toCharArray();
        for(int j = 0; j< array.length; j++){
            if(Character.isDigit(array[j])){
                stringNumber += array[j] - '0';
            }
        }
        return stringNumber;
    }
}
