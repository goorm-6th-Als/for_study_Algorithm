import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] a = new int[n];

        for(int i=0; i<n; i++ ){ 
            a[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(a);

         for(int i = 0; i<n; i++){
            System.out.println(a[i]);
        }

    }
}