package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static List<Integer> feelings;

    public static int findSadFeeling(int position) {
        int len = feelings.size();
        if (position > len || len == 0 || position < 0) throw new RuntimeException("Position or length invalid!");
        for (int i = position; i < len; i++) {
            if (feelings.get(i) == -1) return i;
        }
        return len;
    }

    public static Boolean checkNeighbours(int position) {
        int len = feelings.size()-1;
        if (position > len || len == 0 || position < 0) throw new RuntimeException("Position or length invalid!");
        if (position == 0 || position == len) return false;
        return feelings.get(position) == -1 && feelings.get(position - 1) == 1 && feelings.get(position + 1) == 1;
    }

    public static void insertHappyFeelings(int position) {
        int len = feelings.size()-1;
        if (position > len || len == 0 || position < 0) throw new RuntimeException("Position or length invalid!");
        if (feelings.get(position) == -1) {
            // i=0
            if (position == 0) {
                feelings.add(0, 1);
                if (feelings.get(position + 2) != 1) feelings.add(position + 2, 1);
                return;
            }
            //i=len
            if (position == len) {
                feelings.add(position + 1,1);
                if (feelings.get(position - 1) != 1) feelings.add(position, 1);
                return;
            }
            if (feelings.get(position - 1) != 1) {
                feelings.add(position, 1);
                if (feelings.get(position + 2) != 1) feelings.add(position + 2, 1);
                return;
            }
            if(feelings.get(position+1)!=1){
                feelings.add(position+1,1);
                return;
            }

        }
    }

    public static List<Integer> beHappy(){
        int position=findSadFeeling(0);
        while(position<=feelings.size()-1){
            if(!checkNeighbours(position)) {insertHappyFeelings(position);}
            position=findSadFeeling(position+1);
        }
        return feelings;
    }

    public static void main(String[] args) {

        feelings = new ArrayList<>(Arrays.asList(-1,-1,0,0,1,1,-1,1,0,-1,1,0,1,1,-1, 0,1,1));

        System.out.println(findSadFeeling(3));
        System.out.println(checkNeighbours(6));
        System.out.println(beHappy());
    }
}
