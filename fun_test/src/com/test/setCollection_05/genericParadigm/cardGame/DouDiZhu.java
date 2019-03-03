package com.test.setCollection_05.genericParadigm.cardGame;

import java.util.ArrayList;
import java.util.Collections;

public class DouDiZhu {
    public static void main(String[] args) {

        ArrayList<String> poker = new ArrayList<>();

        String[] colors = {"♠", "♥", "♣", "♦"};

        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        poker.add("大王");
        poker.add("小王");
        for (String number : numbers) {
            for (String color : colors) {
//                System.out.println(color + number);
                poker.add(color + number);
            }
        }
//        System.out.println(poker);
        Collections.shuffle(poker);//打乱集合内的顺序
//        System.out.println(poker);

        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();

        for (int i = 0; i < poker.size(); i++) {
            String p = poker.get(i);
            if(i>=51){
                diPai.add(p);
            }
            else  if(i%3==0){
                player01.add(p);
            }else if(i%3==1){
                player02.add(p);
            }else if(i%3==2){
                player03.add(p);
            }
        }

        System.out.println(player01);
        System.out.println(player02);
        System.out.println(player03);
        System.out.println(diPai);
    }
}
