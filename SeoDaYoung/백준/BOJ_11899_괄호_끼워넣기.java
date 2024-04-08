import java.io.*;
import java.util.*;

public class BOJ_11899_괄호_끼워넣기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0)); // 첫 인덱스 push

        for (int i = 1; i < s.length(); i++) { 
            char c = s.charAt(i);

            // c == '('일 때 push
            if (c == '(') { 
                stack.push(c); 
            } 
            else { // c == ')' 일 때

                // 스택 꼭대기가 '('이면 pop
                if (stack.size() > 0 && stack.peek() == '(') {  
                    stack.pop(); 

                // 스택이 비어 있거나 꼭대기가 '('이 아니면 push
                } else { 
                    stack.push(c);
                }
            }
        }
        // (나오지 못한 값들 = 괄호가 부족한 값들)
        System.out.println(stack.size()); 
    }
}
