package com.s;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//启动类加@Mapperscan在mapper文件中就不需要加@Mapper，也可以扫描
@MapperScan
public class FamilyServicePlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(FamilyServicePlatformApplication.class,args);
    }
}
