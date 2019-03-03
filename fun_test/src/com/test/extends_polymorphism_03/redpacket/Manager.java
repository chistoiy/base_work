package com.test.extends_polymorphism_03.redpacket;

import java.util.ArrayList;

public class Manager extends User {
    public Manager(String name, int money) {
        super(name, money);
    }

    public Manager() {
    }

    public ArrayList<Integer> send(int totalMoney, int count) {
        ArrayList<Integer> redlist = new ArrayList<>();
        int leftMoney = super.getMoney();
        if (leftMoney < totalMoney) {
            System.out.println("余额不足");
            return redlist;
        }
        super.setMoney(leftMoney - totalMoney);
        int avg = totalMoney / count;
        int mod = totalMoney % count;
        for (int i = 0; i < count-1; i++) {

            redlist.add(avg);
        }
        int last = avg+mod;
        redlist.add(last);
        return redlist;
    }

}
