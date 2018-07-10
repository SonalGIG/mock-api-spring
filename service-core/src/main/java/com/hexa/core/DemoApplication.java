package com.hexa.core;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;


@SpringBootApplication
@EnableSwagger2
@ComponentScan(value = "com.hexa")
public class DemoApplication {

    @Value("${wiremock.default.port}")
    int wiremockPort;

    private WireMockServer wireMockServer;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    private void executeWiremockStandalone() {
        wireMockServer = new WireMockServer(wireMockConfig().port(wiremockPort));
        wireMockServer.start();
    }

    @PreDestroy
    private void stopWiremockStandalone() {
        wireMockServer.stop();
    }
}
