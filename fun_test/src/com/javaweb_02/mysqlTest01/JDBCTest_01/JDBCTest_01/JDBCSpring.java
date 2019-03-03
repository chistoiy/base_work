package com.javaweb_02.mysqlTest01.JDBCTest_01.JDBCTest_01;

import com.javaweb_02.mysqlTest01.JDBCTest_01.JDBCTest_01.util.JDBCUtilsPool;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * 导入jar包
 *  创建JDBCTemplate对象，依赖于数据源DataSource
 *      JDBCTemplate template = new JDBCTemplate(ds);
 *
 *      调用JDBCTemplate方法执行crud操作
 *          update(),增删改语句
 *          queryForMap()查询结果封装为map集合,
 *              Map<String,Object> map = template.queryForMap(sql)
 *              如果查询返回两个结果时，会报异常
 *          queryForList()查询结果封装为List集合
 *              List<Map<String,Object>> list = template.queryForList(sql)
 *          query()查询结果封装为JavaBean对象
 *              List<Emp> list =template.query(sql,new RowMapper<Emp>(){
 *                  public Emp mapRow(ResultSet rs,int i ){
 *                      Emp emp = new Emp();
 *                      rs.getInt("id");
 *                      emp.setid("id");
 *                      return emp;
 *                  }
 *              })
 *
 *              或者：
 *              List<Emp> list =template.query(sql,new BeanPropertyRowMapper<Emp>(Emp.class));
 *          queryForObject()查询结果封装为对象
 */


public class JDBCSpring {
    public static void main(String[] args) {


        JdbcTemplate template = new JdbcTemplate(JDBCUtilsPool.getDs());

        String sql="update emp set ename=? where ename=?";

        int count=template.update(sql,"qwqe","rttt");
        System.out.println(count);

    }
}
