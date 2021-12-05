package com.example.asynctest.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.asynctest.services.ASyncTesteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ASyncTesteController {
    @Autowired
    private ASyncTesteService aSyncTesteService;
    
    @GetMapping("/c1")
    public String calculaAsync() throws InterruptedException {
        aSyncTesteService.calculaAsync();
        return "Chamada async metodo anotado com @Async "+DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
    }

    @GetMapping("/c2")
    public String calculaSync() throws InterruptedException {
        aSyncTesteService.calculaSync();
        return "Chamada não async (Metodo não anotado com @Async) "+ DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
    }

    @GetMapping("/c3")
    public String calculaSyncAnotherMethod() throws InterruptedException {
        aSyncTesteService.calculaAsyncAnotherMethod();
        return "Chamada não async (implicações AOP) "+DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
    }

}

