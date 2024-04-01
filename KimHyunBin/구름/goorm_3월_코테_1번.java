import java.io.*;
class Main { // goorm_3월_코테_1번
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        System.out.println(input *(long)Math.pow(10, input));
    }
}