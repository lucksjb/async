package com.example.asynctest.services;

import java.time.Duration;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@EnableAsync
@Slf4j
public class ASyncTesteService {
    
    @Async
    public void calculaAsync() throws InterruptedException {
        Long i = 0L;
        while (i <= 10) {
            log.info("calcula Async "+ i);      
            Thread.sleep(1000L);
            i++;
        }
    }


    public void calculaSync() throws InterruptedException {
        Long i = 0L;
        while (i <= 10) {
            log.info("calcula Sync "+ i);      
            Thread.sleep(1000L);
            i++;
        }
    }


    
    public void calculaAsyncAnotherMethod() throws InterruptedException {
        calculaAsync(); // devido ao AOP esssa chamada não será Async
    }

}
