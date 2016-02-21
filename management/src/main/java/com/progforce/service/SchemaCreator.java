package com.progforce.service;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SchemaCreator {

    private String schema;
    private String url;
    private String user;
    private String pass;
    private String driver;

    public SchemaCreator(String schema, String url, String user, String pass, String driver) {
        this.schema = schema;
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }


    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getDriver() {
        return driver;
    }


    public String getSchema() {
        return schema;
    }

    @PostConstruct
    public void afterPropertiesSet() {
        try {
        	Class.forName(driver);
            DriverManager.getConnection(url + "/" + schema, user, pass);
        } catch (Exception e){
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(pass);
            dataSource.setDriverClassName(driver);

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            // CREATE SCHEMA `new_schema` ;
            jdbcTemplate.execute("CREATE SCHEMA " + schema);
            try {
                dataSource.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

}