package com.javaweb_02.mysqlTest01.JDBCTest_01.JDBCTest_01;

/*
*
* java新版后，jdbc驱动导入方式变化
*   获取驱动对象r，导入驱动
*       Class.forName("com.mysql.cj.jdbc.Driver");
*   获取驱动连接对象，
*       DriverManager.getConnection("jdbc:mysql://localhost:3306/forjavawork?serverTimezone=UTC","root","chis1chang");
*           static Connection getConnection(String url,String user,String password)
*           url:指定连接的路径
*                   连接时本机时，url可以不写ip，域名，端口
*           user：用户名
*           password：密码
*   DriverManager 驱动管理对象
*   Connection 数据库连接对象
*   Statement createStatement() 创建一个 Statement 对象来将 SQL 语句发送到数据库
*       PreparedStatement prepareStatement(String sql) 创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库
*
*       void setAutoCommit(boolean autoCommit) 将此连接的自动提交模式设置为给定状态
*           在需要事务前开启
*       void rollback(Savepoint savepoint) 取消所有设置给定 Savepoint 对象之后进行的更改。
*           放置于try。。catch的catch内，当出现异常立即回滚
*       void commit() 使所有上一次提交/回滚后进行的更改成为持久更改，并释放此 Connection 对象当前持有的所有数据库锁。
*           处理完毕提交
*   Statement 执行sql的对象
*       boolean execute(String sql, String[] columnNames) 执行给定的 SQL 语句（该语句可能返回多个结果），并通知驱动程序在给定数组中指示的自动生成的键应该可用于获取。
*       int executeUpdate(String sql) 执行给定 SQL 语句，该语句可能为 INSERT、UPDATE 或 DELETE 语句，或者不返回任何内容的 SQL 语句（如 SQL DDL 语句）。
*           返回值为受影响的行数
*       ResultSet executeQuery(String sql) 执行给定的 SQL 语句，该语句返回单个 ResultSet 对象
*           执行select，返回了结果集
*       boolean execute(String sql, String[] columnNames)          执行给定的 SQL 语句（该语句可能返回多个结果），并通知驱动程序在给定数组中指示的自动生成的键应该可用于获取。
*   ResultSet结果集对象
*           此对象也需要在最后close()
*           int next()游标向下移动一行(相当于IO流里的readline)
*           getxxx(),方法名以请求获取列的类型而定，参数输入列名或输入列索引号（从1开始）
*           这个结果集使用时，需要手动判断是否到末尾，否则读取时会越界
*               当移动到空行时，next()返回为false
*   PrepareStatement 执行sql的对象
*
* JDBC工具类JDBCUtils
*   简化书写
*       注册驱动抽取
*       抽取方法获取对象
*       冲去方法释放资源
*
*  PreparedStatement:防止注入
*   使用？当作参数占位符
*           String sql3 = "select * from emp where name=? and age>?";
            PreparedStatement pstat = conn.prepareStatement(sql3);
            String name = "qw";
            int age = 12;
            pstat.setString(1,name);
            pstat.setInt(2,age);
            ResultSet rss = pstat.executeQuery();
*
*   Springjdbc
* */

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {

        String a=null;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forjavawork?serverTimezone=UTC", "root", "chis1chang");
             Statement stat  = conn.createStatement();

        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //增加
            //String sql = "update sheet1 set name='qwlwql' where id =2 ";
            //int s = stat.executeUpdate(sql);
            //System.out.println(s);

            //insert
            //System.out.println(conn instanceof java.lang.AutoCloseable);
            //String sql2 = "select * from  sheet1 ";

            //final ResultSet ss = stat.executeQuery(sql2);
            //System.out.println(ss.next());

            //增加
//            String sql = "insert  into sheet1 (name,age) values('akk',12)";
//            int s = stat.executeUpdate(sql);
//            System.out.println(s);



            //drop
//            String sql = "delete from  sheet1 where name='akk' ";
//            int s = stat.executeUpdate(sql);
//            System.out.println(s);

            //select结果集测试
            String sql2 = "select * from  sheet1 ";
            ResultSet ss = stat.executeQuery(sql2);
            ss.next();
            System.out.println(ss.getInt("age"));
            System.out.println(ss.getString(2));

//PreparedStatment
            String sql3 = "select * from emp where ename=? and age>?";
            PreparedStatement pstat = conn.prepareStatement(sql3);
            String name = "qwlwql";
            int age = 12;
            pstat.setString(1,name);
            pstat.setInt(2,age);
            ResultSet rss = pstat.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }





        //CRUD


    }
}
