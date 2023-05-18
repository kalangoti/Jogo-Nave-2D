package com.santo.spaceship.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Responsável por configurar os serviços do spring
@Configuration
@ComponentScan({
        "com.santo.spaceship", "src/main/resources"})
public class Build {
    // Build 1: Adaptador Testes -> Sistema <- Adptadores Mocks
}
