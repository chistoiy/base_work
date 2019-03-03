package com.test.inerclass_outerclass_04;

import com.test.inerclass_outerclass_04.redPacket.OpenMode;
import java.util.ArrayList;
import java.util.Random;

public class RandomMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();

        Random r = new Random();

        int leftMoney = totalMoney;
        int leftCount =totalCount;

        for (int i = 0; i < totalCount-1; i++) {
            int money = r.nextInt(leftMoney/leftCount*2)+1;
            list.add(money);
            leftMoney-=money;
            leftCount--;

        }
        list.add(leftMoney);



        return list;
    }
}
