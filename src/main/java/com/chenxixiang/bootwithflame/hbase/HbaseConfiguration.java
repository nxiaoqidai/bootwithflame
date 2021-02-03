package com.chenxixiang.bootwithflame.hbase;

import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class HbaseConfiguration {

    @Bean
    public Connection getHbaseConnection(){

        try {
            return ConnectionFactory.createConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
