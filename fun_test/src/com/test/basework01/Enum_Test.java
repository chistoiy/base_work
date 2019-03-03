package com.test.basework01;

class FreshJuice{
    enum FreshJuiceSize{ SMALL,MEDIUM,LARGE }
    FreshJuiceSize size;
}

public class Enum_Test {
    public static void main(String[] args){
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.MEDIUM ;
        System.out.println(juice.size);
    }
}
