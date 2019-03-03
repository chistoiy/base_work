package com.test.inerclass_outerclass_04;

import com.test.inerclass_outerclass_04.redPacket.OpenMode;

import java.util.ArrayList;

public class NormalMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();

        int avg = totalMoney / totalCount;
        int mod = totalMoney % totalCount;
        for (int i = 0; i < totalCount - 1; i++) {
            list.add(avg);
        }
        //最后一个给群主，当除不尽时余数给最后一个红包
        list.add(avg + mod);

        return list;
    }
}
