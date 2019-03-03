package com.javaweb_02.mysqlTest01.JDBCTest_01.JDBCTest_01;

import com.javaweb_02.mysqlTest01.JDBCTest_01.JDBCTest_01.util.JDBCUtils;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class Test01 {

    public static List<Emp> FindAll() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql:///forjavawork?serverTimezone=UTC", "root", "chis1chang");
             Statement stat = conn.createStatement();
        ) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "select * from emp";

            ResultSet r = stat.executeQuery(sql);
            System.out.println(r);
            while(r.next()){
                System.out.println( r.getInt("id"));
               ;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void testjdbcutils(){
        Connection conn = JDBCUtils.getConnection();
        try {
            Statement stat = conn.createStatement();
            String sql = "select * from emp";

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        FindAll();
        testjdbcutils();
    }

}


class Emp {
    private int id;
    private String ename;
    private int job_id;
    private int mgr;
    private Date joindate;
    private double salary;
    private double bounds;
    private int dept_id;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", job_id=" + job_id +
                ", mgr=" + mgr +
                ", joindate=" + joindate +
                ", salary=" + salary +
                ", bounds=" + bounds +
                ", dept_id=" + dept_id +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBounds() {
        return bounds;
    }

    public void setBounds(double bounds) {
        this.bounds = bounds;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }
}