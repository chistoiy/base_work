package com.test.extends_polymorphism_03.redpacket;

public class User {
    private String name;
    private int money;

    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public User() {
    }
    public void show(){
        System.out.println("用户："+name+"拥有："+money+"元余额");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
