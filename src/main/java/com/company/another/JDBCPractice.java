package com.company.another;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCPractice {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("xx", "rt", "aw");
//        connection.setT
    }
}
