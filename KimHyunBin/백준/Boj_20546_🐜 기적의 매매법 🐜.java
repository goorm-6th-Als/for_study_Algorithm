import java.util.*;
import java.io.*;

public class Main {// Boj_2578_빙고

	static int cash, stock, SM_stock, SM_cash;
	static String answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		cash = Integer.parseInt(st.nextToken());
		
		int timing = 0;	
		int pre_price = 0;
		stock = 0;
		SM_stock = 0;
		SM_cash = cash;
		answer = "SAMESAME";
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=14; i++) {
			int price = Integer.parseInt(st.nextToken());	
			
			// 성민 매매법 구현
			if(timing == 0) { 
				if(price > pre_price) {
					timing += 1;
				}else if(price < pre_price) {
					timing -= 1;
				}
			}else if(timing > 0){
				if(price > pre_price) {
					timing += 1;
				}else if(price < pre_price) {
					timing = 0;
				}
			}else if(timing < 0){
				if(price < pre_price) {
					timing -= 1;
				}else if(price > pre_price) {
					timing = 0;
				}
			}
			
			if(timing <= -2 && SM_cash >= price) {
				SM_stock += SM_cash/price;
				SM_cash %= price;
//				System.out.println(price+" "+i+"일차 구매 " + "현금:"+cash + " 주식:"+SM_stock);
			}else if(timing >= 2 && SM_stock > 0){
				SM_cash += (SM_stock * price);
				SM_stock = 0;
//				System.out.println(i+"일차 판매" + "현금:"+cash + " 주식:"+SM_stock);
			}
			
			if(cash >= price) {
				stock += cash/price;
				cash %= price;
			}
			
			pre_price = price;
			
			if(i == 14) {
				SM_cash += SM_stock * price;
				cash += stock * price;
//				System.out.println(SM_cash + " " +cash);
				if(SM_cash>cash) {
					answer = "TIMING";
				}else if(cash > SM_cash) {
					answer ="BNP";
				}else {
					answer = "SAMESAME";
				}
			}
		}
		
		System.out.println(answer);

	}
}