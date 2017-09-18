package com.speedmax.trade.service;

import com.speedmax.trade.BaseTest;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.mapping.Collection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPoolTest extends BaseTest{

    @Autowired
    private HikariDataSource dataSource;

    @Autowired
    private RestTemplate restTemplate;

    private Connection connection;

    @After
    public void afterAll() {
        if(null != this.connection) {
            try {
                this.connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void simpleTest() throws SQLException {
        final String simpleSql = "SELECT * FROM `test_user`";
        this.connection = dataSource.getConnection();
        Statement statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery(simpleSql);
        Assert.assertEquals(rs.getFetchSize(), 0);
    }

    @Test
    public void insertAndVerifyTest() throws SQLException {
        final String insertTestUserSql = "INSERT INTO `test_user` (firstName, lastName) VALUES ('Speed', 'Xu')";
        final String queryTestSql = "SELECT * FROM `test_user`";
        this.connection = dataSource.getConnection();
        Statement statement = this.connection.createStatement();
        statement.execute(insertTestUserSql);
        ResultSet rs = statement.executeQuery(queryTestSql);
        while(rs.next()) {
            Assert.assertEquals(rs.getString("firstName"), "Speed");
            Assert.assertEquals(rs.getString("lastName"), "Xu");
        }
    }

    @Test
    public void concurrentApiPerformanceTest() {

    };
}
