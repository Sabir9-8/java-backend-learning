package com.sabir.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DbUtil {

    private static final HikariDataSource dataSource;
	static {
		Properties properties = new Properties();
		try (InputStream input = DbUtil.class.getClassLoader().getResourceAsStream("db.properties")){

			if (input == null) {
                throw new IllegalStateException(
                    "db.properties not found on classpath"
                );
            }
			properties.load(input);

			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(properties.getProperty("db.url"));
			config.setUsername(properties.getProperty("db.username"));
			config.setPassword(properties.getProperty("db.password"));
			config.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.maximumPoolSize", "5")));
			config.setMinimumIdle(Integer.parseInt(properties.getProperty("db.minimumIdle", "1")));
			dataSource = new HikariDataSource(config);
			
		} catch (IOException | RuntimeException e) {
            throw new ExceptionInInitializerError(e);
        }
	}

    private DbUtil() {
		
	}

    public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

    public static void closeDataSource() {
		if (!dataSource.isClosed()) {
            dataSource.close();
        }
	}
}
