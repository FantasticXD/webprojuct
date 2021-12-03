package com.xfq.dao.impl;

import com.xfq.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner querryrunner =new QueryRunner();
    /**
     *
     * 通用的增删改
     * */
    public int update(String sql,Object ...args){
        Connection con = JDBCUtils.getConnection();
        try {
            return querryrunner.update(con,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeconnection(con);
        }
        return -1;
    }
    /**
     * 查询一个对象
     * */
    public <T> T Queryone(Class<T> clazz,String sql,Object ...args){
        Connection con = JDBCUtils.getConnection();

        try {
          return  querryrunner.query(con,sql,new BeanHandler<T>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeconnection(con);
        }
        return null;
    }
    public  <T> List<T> QueryList(Class<T> clazz, String sql, Object ...args){
        Connection con = JDBCUtils.getConnection();

        try {
            return  querryrunner.query(con,sql,new BeanListHandler<T>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeconnection(con);
        }
        return null;
    }

    public Object QuerySingal(String sql,Object ...args){
        Connection con = JDBCUtils.getConnection();
        try {
            return  querryrunner.query(con,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeconnection(con);
        }
        return null;
    }
}
