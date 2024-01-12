package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_2606_바이러스 {
    static int[][] network;
    static boolean[] isChecked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computers = Integer.parseInt(br.readLine());
        int size = Integer.parseInt(br.readLine());

        network = new int[computers+1][computers+1];
        isChecked = new boolean[computers+1];

        for(int i = 0; i<size; i++){
            String[] input = br.readLine().split(" ");
            int computer = Integer.parseInt(input[0]);
            int otherComputer = Integer.parseInt(input[1]);
            network[computer][otherComputer] = 1;
            network[otherComputer][computer] = 1;
        }

        System.out.println(bfs(1));
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int size = 0;
        while(!queue.isEmpty()){
            int num = queue.poll();
            isChecked[num] = true;
            for(int i = 1; i<network[num].length; i++){
                if(network[num][i] == 1 && !isChecked[i]){
                    isChecked[i] = true;
                    size++;
                    queue.add(i);
                }
            }
        }
        return size;
    }
}
