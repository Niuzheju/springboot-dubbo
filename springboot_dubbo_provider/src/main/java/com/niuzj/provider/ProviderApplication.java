package com.niuzj.provider;

import com.alibaba.dubbo.config.ProtocolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:callback.xml")
public class ProviderApplication {

    public static void main(String[] args) {
        //手动设置dubbo优雅退出
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("jvm退出...");
            ProtocolConfig.destroyAll();
        }
        ));
        SpringApplication.run(ProviderApplication.class, args);
    }
}
