package com.dbatyuk.rps.config;

import com.hazelcast.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RockPaperScissorsConfig {

    @Bean
    public Config hazelCastConfig(){
        return new Config();
    }
}
