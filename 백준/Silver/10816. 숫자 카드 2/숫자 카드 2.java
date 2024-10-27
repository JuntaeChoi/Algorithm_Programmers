import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer hasCard = new StringTokenizer(br.readLine()," ");
        int m = Integer.parseInt(br.readLine());
        StringTokenizer countCard = new StringTokenizer(br.readLine()," ");

        HashMap<Integer,Integer> map = new HashMap();
        while(hasCard.hasMoreTokens()){
            int card = Integer.parseInt(hasCard.nextToken());
            if(map.putIfAbsent(card,1)!=null){
                map.replace(card,map.get(card)+1);
            }
        }
        while(countCard.hasMoreTokens()){
            sb.append(map.getOrDefault(Integer.parseInt(countCard.nextToken()),0));
            sb.append(" ");
        }
        System.out.println(sb);
    }
}