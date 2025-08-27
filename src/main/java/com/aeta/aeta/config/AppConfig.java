package com.aeta.aeta.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class AppConfig {

        //for entity to dto
        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }

