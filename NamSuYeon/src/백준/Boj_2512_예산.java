package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2512_예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        int sum = Integer.parseInt(br.readLine());

        for(int i = 0; i<size; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> answerList = new ArrayList<>();
        Collections.sort(list);
        int calculateSum = 0;
        for(int i = 0; i<size; i++){
            if(calculateSum <sum){
                calculateSum+= list.get(i);
                answerList.add(list.get(i));
            }else{
                calculateSum -= answerList.remove(answerList.size()-1);
                break;
            }
        }

        if((list.size()-answerList.size()) !=0){
            sum = (sum -calculateSum)/(list.size()-answerList.size());
        }

        if(sum > answerList.get(answerList.size()-1)){
            System.out.println(sum/2);
        }else{
            answerList.get(answerList.size()-1);
        }
    }
}
