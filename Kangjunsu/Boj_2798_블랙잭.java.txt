import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] cards = new int[n];

        for(int i=0; i<n; i++){
            cards[i]= sc.nextInt();
        }
        Arrays.sort(cards);

        int k = (n*(n-1)*(n-2))/6;  //nC3
        int[] sum = new int[k];
        int idx =0;

        for(int i=n-1; i>=2; i--){
            for(int j =i-1; j>=1; j--){
                for(int t= j-1; t>=0; t--){

                    sum[idx] = cards[i] + cards[j] + cards[t];
                    if(sum[idx]>m){
                        sum[idx]=0;
                    }
                    idx++;
                }
            }
        }
        Arrays.sort(sum);
        System.out.println(sum[idx-1]);
    }
}