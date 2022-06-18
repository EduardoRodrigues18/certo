package com.tenis.apirest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TenisRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Tenis("Jordan ", "Nike ", 41)));
            log.info("Preloading " + repository.save(new Tenis("Dunk ", "Nike ", 39)));
        };
    }
}
