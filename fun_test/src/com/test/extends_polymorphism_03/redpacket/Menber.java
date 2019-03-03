package com.test.extends_polymorphism_03.redpacket;

import java.util.ArrayList;
import java.util.Random;

public class Menber extends User {
    public Menber(String name, int money) {
        super(name, money);
    }

    public Menber() {

    }
    public void receive(ArrayList<Integer> list){
        int index = new Random().nextInt(list.size());
        super.setMoney(super.getMoney()+list.remove(index));
    }

}
