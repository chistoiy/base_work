package com.javaweb_02.mysqlTest01.JDBCTest_01.JDBCTest_01;

/*
* 数据库连接池
*
*   连接池技术
*       C3P0
*           导包
*               c3p0-0.9.5.2.jar，mchange-commons-java-0.2.11.jar导入文件
*               同时jdbc的jar文件也要导入
*           定义配置文件：
*               c3p0.properties/c3p0-config.xml限定文件名为其中一者
*               路径：
*                   位于src目录下
*           船舰核心对象：
*               数据库连接池对象 ComboPoolDataSource(),传入配置名称，则根据指定配置创建pool
*           获取连接
*                   getConnection
*           关闭连接
*                   conn.close
*       Druid 阿里巴巴提供，广泛使用
*           导包
*           配置文件
*               druid.properties
*             位置：任意位置，手动加载
*           获取连接池对象：
*               通过工厂类获取 DruidDataSourceFactory
*
*
* */

import com.alibaba.druid.pool.DruidDataSourceFactory;
import  com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCPool {
    public static void main(String[] args) {
//pool测试
//       pool();
pool2();


    }

    static void pool(){//c3p0连接池使用

        DataSource ds = new ComboPooledDataSource();
        try {

            Connection conn = ds.getConnection();
            Statement stat = conn.createStatement();
            ResultSet rr = stat.executeQuery("select * from emp");

            while(rr.next()){
                System.out.println(rr.getInt("id"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void pool2(){



        Properties pro = new Properties( );
        InputStream is = JDBCPool.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(is);
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            Connection conn = ds.getConnection();

            Statement stat = conn.createStatement();
            ResultSet rr = stat.executeQuery("select * from emp");

            while(rr.next()){
                System.out.println(rr.getInt("id"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
