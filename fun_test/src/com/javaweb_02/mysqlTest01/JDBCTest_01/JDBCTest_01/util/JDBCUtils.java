package com.javaweb_02.mysqlTest01.JDBCTest_01.JDBCTest_01.util;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
private static String url;
private static String user;
private static String password;
private static String driver;
private static DataSource ds;



    static{
        Properties pro =new   Properties();
        try {

            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL ll = classLoader.getResource("jdbc.properties");
//            System.out.println(ll.getPath());
            pro.load(new FileReader(ll.getPath()));
        url = pro.getProperty("url");
        user = pro.getProperty("user");
        password = pro.getProperty("password");
        driver = pro.getProperty("driver");
        Class.forName(driver);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public  static Connection getConnection(){


        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void close(ResultSet rs, Statement stmt, Connection conn){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static DataSource getDataSource(){
        return  ds;
    }

}
