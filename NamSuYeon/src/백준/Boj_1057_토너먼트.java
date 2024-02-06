package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1057_토너먼트 {

    static List<Integer> entrant;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        entrant = new ArrayList<>();
        int mine = Integer.parseInt(st.nextToken());
        int you = Integer.parseInt(st.nextToken());

        for(int i = 1; i< size+1; i++){
            entrant.add(i);
        }
        int i = 1;
        boolean isChecked = false;
        do{
            for(int j = 0; j<entrant.size()-1; j++){
                if((entrant.get(j) == mine && entrant.get(j+1) == you) || (entrant.get(j+1) == mine && entrant.get(j) == you)){
                    isChecked = true;
                    break;
                }else if(entrant.get(j) == mine || entrant.get(j) == you){
                    entrant.remove(j+1);
                }else if(entrant.get(j+1) == mine || entrant.get(j+1) == you){
                    entrant.remove(j);
                }else{
                    entrant.remove(j+1);
                }
            }
            if(isChecked){
                break;
            }else{
                size = size/2;
            }
            i++;

        }while (size != 1 );

        System.out.println(i);
    }
}
