package com.test.setMap_06;

import java.util.*;

public class CardGame {
    public static void main(String[] args) {

        String[] s = {"♥", "♣", "♦", "♠"};
        String[] ns = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        int index = 0;

        ArrayList<Integer> pokerIndex = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        for (String s1 : s) {
            for (String n : ns) {
                map.put(index, n + s1);
                pokerIndex.add(index);
                index++;
            }
        }

        map.put(index, "大王");
        pokerIndex.add(index);
        index++;
        map.put(index, "小王");
        pokerIndex.add(index);
        for (int s1 : map.keySet()) {
            System.out.println(map.get(s1) + ":" + s1);
        }

        Collections.shuffle(pokerIndex);

        ArrayList<Integer> p1 = new ArrayList<>();
        ArrayList<Integer> p2 = new ArrayList<>();
        ArrayList<Integer> p3 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();

        for (Integer integer : pokerIndex) {
            Integer in = pokerIndex.get(integer);
            if(integer>=51){
                diPai.add(in);
            }else if(integer%3==0){
                p1.add(in);
            }else if(integer%3==1){
                p2.add(in);
            }else if(integer%3==2){
                p3.add(in);
            }
        }
        Collections.sort(p1);
        Collections.sort(p2);
        Collections.sort(p3);
        Collections.sort(diPai);


        show("1号",p1,map);
        show("2号",p2,map);
        show("3号",p3,map);
        show("底牌",diPai,map);




    }

    static void show(String name ,ArrayList list,Map map){
        System.out.print(name+":");
        for (Object o : list) {
            System.out.print(map.get(o));

        } System.out.println();
    }


}
