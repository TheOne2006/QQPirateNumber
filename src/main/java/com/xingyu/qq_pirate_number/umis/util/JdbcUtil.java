package com.xingyu.qq_pirate_number.umis.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

class JdbcUtil {
    private static DataSource ds;

    static {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("Loading.properties");

            Properties ps = new Properties();
            if (in != null) {
                ps.load(in);
                ds = DruidDataSourceFactory.createDataSource(ps);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Connection getConn() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            return null;
        }
    }

    static void closeConn(Connection conn, Statement st, ResultSet rs) {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println();
        }
        try {
            st.close();
        } catch (Exception e) {
            System.out.println();
        }

        try {
            rs.close();
        } catch (Exception e) {
            System.out.println();
        }
    }
}
