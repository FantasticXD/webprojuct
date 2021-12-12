package com.xfq.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DruidDataSource dataSource = new DruidDataSource();
    private static ThreadLocal<Connection> conn = new ThreadLocal<Connection>();

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
        Connection connection1 = conn.get();
        if (connection1 == null) {
            try {
                Connection connection = dataSource.getConnection();
                connection.setAutoCommit(false);
                conn.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn.get();
    }

    public static void commitAndClose() {
        Connection connection = conn.get();
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
        conn.remove();

    }

    public static void rollbackAndClose() {
        Connection connection = conn.get();
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
        conn.remove();

    }
}
