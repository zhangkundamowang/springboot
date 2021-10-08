package com.zk.springboot;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@MapperScan("com.zk.springboot.modular.mapperni ") // 扫描mapper类，把bean加入到spring容器管理
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("程序启动成功！");
        System.out.println("本地调试文档地址：http://localhost:8881/swagger-ui.htmll");
    }

}
