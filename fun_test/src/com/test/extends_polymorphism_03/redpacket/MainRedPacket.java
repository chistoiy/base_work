package com.test.extends_polymorphism_03.redpacket;

import java.util.ArrayList;

public class MainRedPacket {
    public static void main(String[] args) {
        Manager manager=new Manager("群主",100);
        Menber one = new Menber("A",0);
        Menber two = new Menber("B",0);
        Menber thr = new Menber("C",0);
        one.show();
        two.show();
        thr.show();
        manager.show();
        System.out.println("================");
        ArrayList<Integer> redlist = manager.send(50,2);
        manager.show();
        one.receive(redlist);
        two.receive(redlist);
        thr.receive(redlist);
        one.show();
        two.show();
        thr.show();

    }
}
