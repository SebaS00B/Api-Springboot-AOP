package com.sebas.springboot.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

@Service
public interface GreetingService {

    String sayHello(String person, String phrase);
    String sayHelloError(String person, String phrase);

}
