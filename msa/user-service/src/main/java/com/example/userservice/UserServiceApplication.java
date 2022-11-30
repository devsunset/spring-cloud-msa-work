package com.example.userservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @GetMapping("/user/info")
    public String info(@Value("${server.port}") String port) {
        return "User  서비스의 기본 동작 Port: {" + port + "}";
    }
    
//  @GetMapping("/info") -  yaml 설정 RewritePath=/user/?(?<segment>.*), /$\{segment}  # /user/ 경로를 없앰
//  public String info(@Value("${server.port}") String port) {
//      return "User 서비스의 기본 동작 Port: {" + port + "}";
//  }

    @GetMapping("/user/auth")
    public String auth(@RequestHeader(value = "token") String token) {
        return "token is " + token;
    }
    
    @GetMapping("/user/config")
    public String string(@Value("${message.owner}") String messageOwner,
                         @Value("${message.content}") String messageContent) {
        return "Configuration File's Message Owner: " + messageOwner + "\n"
                + "Configuration File's Message Content: " + messageContent;
    }


}