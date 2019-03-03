package com.test.setMap_06;

import java.util.HashMap;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        char [] a = st.toCharArray();
        System.out.println(a);
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
            if(map.containsKey(a[i])){
                int v = map.get(a[i]);
                map.put(a[i],++v);
            }else{
                map.put(a[i],1);
            }
        }
        System.out.println(map);

        for (char c : a) {
            if(map.containsKey(c)){
                int v = map.get(c);
                map.put(c,++v);
            }else{
                map.put(c,1);
            }
        }

        for (Character character : map.keySet()) {
            int v = map.get(character);
            System.out.println(character+":"+v);
        }

    }
}
