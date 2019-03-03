package com.test.basework01;

public class PanDuan {
   public static void main(String[] args){

       int age = 16;
       if(age>=18){
           System.out.println("已成年");
       }else if(age>=17){
           System.out.println("快成年了");
       }
       else{
           System.out.println("未成年");
       }

       int boss=20;
        switch (boss){
            case 0:
                System.out.println("0");
                break;
            case 20:
                System.out.println("20");
                break;
            default:
                System.out.println("nothing");
                break;
        }

        /*
        * for循环
        * */
        for(int i=0;i<10;i++){
            System.out.println(i);
        }
        int i =10;
        while(i>5){
            i--;
            System.out.println(i);
        }
        int k =10;
        do {
            System.out.println(k);
            k--;
       }while(k>5);

        //
       int sum = 0;
       for(int j=1;j<=100;j++){
           if(j%2==0){
               sum+=j;
               //break;一旦满足，立即跳出当前for
               //continue;一旦满足，for循环体之后的不再执行，开始下一次循环
           }
       }
       System.out.println(sum);
       int sum2 = 0;
       for(int j=0;j<=100;j+=2){
               sum2+=j;
       }
       System.out.println(sum2);
       System.out.println(twoNume(1,2));
       System.out.println(addNume(1,100));
   }
   public static boolean twoNume(int a,int b){
       boolean same;
       return (a==b)?true:false;
   }
   public static int addNume(int e,int b ){
       int sum = 0;

       for(int i =e;i<=b;i++){
           sum+=i;
       }
       return sum;
   }
}
