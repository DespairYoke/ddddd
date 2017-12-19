package com.hlw.zwd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by liumapp on 9/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@SpringBootApplication(scanBasePackages ={"com.hlw.zwd"} )
@MapperScan(basePackages ="com.hlw.zwd.mapper")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class , args);
    }

}
