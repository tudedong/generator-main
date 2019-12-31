package com.td.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tudedong
 * @description
 * @date 2019-12-30 15:26:56
 */
@SpringBootApplication
@MapperScan({"com.td.generator.mapper"})
public class TdGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TdGeneratorApplication.class, args);
    }

}
