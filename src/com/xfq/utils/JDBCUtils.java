package com.xfq.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DruidDataSource dataSource = new DruidDataSource();

    static {
        try (InputStream inputstream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        ) {
            Properties pro = new Properties();
            pro.load(inputstream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = (Connection) dataSource.getConnection();
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeconnection(Connection con){
        if (con!=null){
            try {
                con .close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
