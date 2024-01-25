import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt=0;
        int number =666;

        for(int i = 0; ;i++){

            if((number+"").contains("666")){
                cnt++;
//                System.out.println("cnt : " + cnt + ", number : " +number);
                if(cnt ==N){
                    break;
                }
            }
            number +=1;
        }
        System.out.println(number);

    }
}
