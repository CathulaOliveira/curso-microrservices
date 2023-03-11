package br.com.mscartoes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
@Slf4j
public class CartoesApplication {

    public static void main(String[] args) {
        // exemplos de logs
        log.info("log de info");
        log.error("log de erro");
        log.warn("log warn");
        SpringApplication.run(CartoesApplication.class, args);
    }

}
