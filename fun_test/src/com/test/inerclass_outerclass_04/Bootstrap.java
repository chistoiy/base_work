package com.test.inerclass_outerclass_04;

import com.test.inerclass_outerclass_04.redPacket.OpenMode;

public class Bootstrap {
    public static void main(String[] args) {
        MyRed myred = new MyRed("红包分发");
        myred.setOwnerName("马云");
        OpenMode normal = new NormalMode();
       // myred.setOpenWay(normal);//普通红包
        RandomMode randomMode=new RandomMode();
        myred.setOpenWay(randomMode);
    }

}
