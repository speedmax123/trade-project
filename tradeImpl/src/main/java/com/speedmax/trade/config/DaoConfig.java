package com.speedmax.trade.config;


import com.sun.jersey.api.client.Client;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.sql.Connection;
import java.util.concurrent.ThreadPoolExecutor;

@ComponentScan(basePackages = "com.speedmax.trade")
@Configuration
@EnableJpaRepositories("com.speedmax.trade.dao")
public class DaoConfig {
    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig cfg = new HikariConfig();
        cfg.setJdbcUrl("jdbc:mysql://localhost:13306/TRADE_SYSTEM_VERSION_1_0_0?useSSL=false");
        //cfg.setTransactionIsolation(String.valueOf(Connection.TRANSACTION_SERIALIZABLE)); // trying to solve the concurrent problem the worst way
        cfg.setUsername("speedmax");
        cfg.setPassword("abcd1234");
        cfg.setReadOnly(false);
        cfg.addDataSourceProperty("cachePrepStmts", "true");
        cfg.addDataSourceProperty("prepStmtCacheSize", "250");
        cfg.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        cfg.setAutoCommit(false);
        return new HikariDataSource(cfg);
    }
}
