package com.weblibrary.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * 提供连接数据库,释放数据库等功能实现,
 */
public class DBUtil {
        private static DataSource dataSource = null;
        static{
                dataSource =   new ComboPooledDataSource("weblibrary");
        }
        /**
         *  获取一个Connection实例
         * @return
         * @throws SQLException
         */
        public static  Connection getConnection() {
            try {
                return dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static void releaseConnection(Connection connection){
            try{
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public static void release(ResultSet rs, Statement statement){
        try{
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            if(statement != null){
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
