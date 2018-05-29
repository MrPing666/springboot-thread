package com.ping.thread.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Mr.Ping on 2018/5/4.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.ping.thread")
public class Entry {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Entry.class, args);
    }
}
