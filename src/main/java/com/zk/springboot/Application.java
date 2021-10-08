package com.zk.springboot;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@MapperScan("com.zk.springboot.*.mapper") // 扫描mapper类，把bean加入到spring容器管理
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("程序启动成功！");

        //System.out.println("本地调试文档地址：http://localhost:8881/swagger-ui.html");
        //由于我使用了swagger第三方ui：swagger-bootstrap-ui，所以我直接访问url：http://localhost:8881/doc.html
        System.out.println("本地调试文档地址：http://localhost:8881/doc.html");
    }

}
