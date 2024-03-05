import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] dwarves = new int[9];
        for(int i =0; i<9; i++){
            dwarves[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(dwarves);

        int minus = -100;

        for(int a : dwarves){
            minus+=a;
        }

        loop1:
        for(int i=0; i<8; i++){
            for(int j=i+1; j<=8;j++){
                if(dwarves[i]+dwarves[j]==minus) {
                   // System.out.println(dwarves[i] +", " + dwarves[j]);
                    for(int k : dwarves){
                        if(k!=dwarves[i] && k!=dwarves[j]){
                            System.out.println(k);
                        }
                    }
                    break loop1;
                }
            }
        }

    }
}