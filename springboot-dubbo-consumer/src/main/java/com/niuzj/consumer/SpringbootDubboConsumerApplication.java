package com.niuzj.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({
        "classpath:parameter-validation.xml",
        "classpath:group-merged.xml",
        "classpath:normal.xml",
        "classpath:result-cache.xml"})
public class SpringbootDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboConsumerApplication.class, args);
    }
}
