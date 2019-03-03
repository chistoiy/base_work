package com.test.apitest_02;

/*
 *
 *
 * */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateApiTest {
    public static void main(String[] args) throws ParseException {

        //Date 测试
        dateApiTest();
        //DateFormat 测试;该包是一个接口类，需要使用其实现类SimpleDateFormat
        System.out.println("================");
        dateFormatTest();
        System.out.println("================");
        //rangenum();

        System.out.println("================");
        //calendar类是一个抽象类，其提供一个静态方法getInstance()返回一个可操作的日历对象
        calendarTest();
    }

    static void dateApiTest() {
        //Date 测试
        Date time = new Date();
        System.out.println(time);
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date(System.currentTimeMillis() - 20000));

        System.out.println(new Date(0L));//毫秒转日期

        System.out.println(new Date().getTime());//日期转毫秒
    }

    static void dateFormatTest() throws ParseException {
        //时间格式化
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        System.out.println(df1.format(System.currentTimeMillis()));

        SimpleDateFormat df2 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String str = "2019.02.20 公元 at 15:34:48 CST";

        System.out.println(df2.parse(str));

    }

    static void rangenum() throws ParseException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        long now = new Date().getTime();
        System.out.println("输入出生日期如：2019.1.19");
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        Date birth = df.parse(str);
        long rang_time = now - birth.getTime();
        System.out.println("距今过去了" + rang_time / 1000 / 60 / 60 + "小时：" + rang_time / 1000 / 60 % 60 + "分钟");
    }

    static void calendarTest() {
        /*
        * get(calendar.field)获取静态变量，年月日一类信息
        * set(field,int),设置相关信息
        * add(field,delta) 偏移时间
        * public Date getTime();返回一个Date对象
        * */
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));//返回的月份均是从0开始的，所以具体应用时需要+1
        System.out.println(c.get(Calendar.DATE));
        c.set(Calendar.YEAR,2010);
        c.set(2012,10,19);
        System.out.println(c.get(Calendar.YEAR));//设置年份

        c.add(Calendar.YEAR,2);
        System.out.println(c.get(Calendar.YEAR));

        System.out.println(c.getTime());

    }

}
