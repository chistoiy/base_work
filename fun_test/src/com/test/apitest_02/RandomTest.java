package com.test.apitest_02;
import java.util.Random;
import java.util.Scanner;
public class RandomTest {
    public static void main(String[] args) {
        Random r = new Random();
        int x = r.nextInt();//不限范围时，则为正负全数字
        System.out.println(x);
        int k = r.nextInt(3);//0~2的随机整数
        System.out.println(k);
        int kk = r.nextInt(50);
        int y = new Scanner(System.in).nextInt();
        while(true){
            if(kk<y){
                System.out.println("太大了");
                 y = new Scanner(System.in).nextInt();
            }else if(kk>y){
                System.out.println("太小了");
                y = new Scanner(System.in).nextInt();
            }else{
                System.out.println("对了");
                break;
            }
        }
        
    }
}
