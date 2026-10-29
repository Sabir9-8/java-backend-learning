package com.sabir.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DbUtil {

    private static final HikariDataSource dataSource;
	static {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3307/testdb");
		config.setUsername("admin");
		config.setPassword("adminpassword");
		config.setMaximumPoolSize(5);
		config.setMinimumIdle(1);
		dataSource = new HikariDataSource(config);
	}

    private DbUtil() {
		
	}

    public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

    public static void closeDataSource() {
		if (dataSource != null || !dataSource.isClosed()) {
            dataSource.close();
        }
	}
}
