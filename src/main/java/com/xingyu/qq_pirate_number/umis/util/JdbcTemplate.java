package com.xingyu.qq_pirate_number.umis.util;

import com.xingyu.qq_pirate_number.umis.dao.IResultSetHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTemplate {
    public static void update(String sql, Object... objects) {
        Connection conn = JdbcUtil.getConn();
        PreparedStatement ps;
        try {
            if (conn == null) {
                return;
            }
            ps = conn.prepareStatement(sql);
            if (ps == null) {
                return;
            }
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, objects[i]);
            }
            ps.executeUpdate();
            JdbcUtil.closeConn(conn, ps, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T query(String sql, IResultSetHandler<T> rsh, Object... objects) {
        Connection conn = JdbcUtil.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null) {
                return null;
            }
            ps = conn.prepareStatement(sql);
            if (ps == null) {
                return null;
            }
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, objects[i]);
            }
            rs = ps.executeQuery();
            return rsh.handle(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConn(conn, ps, rs);
        }
        return null;
    }
}
