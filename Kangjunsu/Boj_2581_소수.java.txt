import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        List<Integer> sosu = new ArrayList<>();

        //소수 취합
        for(int i= a; i<=b; i++ ){
            loop1:
            for(int j=2; j<=i; j++){

                if(i%j==0 && i!=j){
                    break loop1;
                }
                if(i==j){
                    sosu.add(i);
                }
            }
        }

        if(sosu.size() ==0){
            System.out.println(-1);
        }else {
            int answer =0;
            for(int i : sosu){
                answer +=i;
            }
            System.out.println(answer);
            System.out.print(sosu.get(0));
        }

    }
}