package com.javaweb_02.mysqlTest01.JDBCTest_01.JDBCTest_01.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * druid连接池工具类
 */

public class JDBCUtilsPool {

    private static DataSource ds;

    static {
        Properties pro =new Properties();
        try {
            pro.load(JDBCUtilsPool.class.getClassLoader().getResourceAsStream("druid.properties"));

       ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void close(Connection conn, Statement stat){
if(conn!=null) {
    try {
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
        if(stat!=null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}

    public static void close(ResultSet rs,Connection conn, Statement stat){
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }}





    }

    public static DataSource getDs() {
        return ds;
    }


}
