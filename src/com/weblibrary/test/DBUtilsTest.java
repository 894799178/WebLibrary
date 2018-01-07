package com.weblibrary.test;

import com.weblibrary.db.DBUtil;
import org.junit.Test;

import java.sql.SQLException;

public class DBUtilsTest {

    @Test
    public void testConnection() throws SQLException {
        System.out.println( DBUtil.getConnection());

    }
}
