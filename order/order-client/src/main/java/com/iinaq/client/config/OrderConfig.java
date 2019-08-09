package com.iinaq.client.config;

import com.iinaq.client.fallback.OrderServiceFallBack;
import com.iinaq.client.fallback.OrderServiceFallbackFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {
    @Bean
    public OrderServiceFallBack fallBack(){
        return new OrderServiceFallBack();
    }
    @Bean
    public OrderServiceFallbackFactory factory(){
        return new OrderServiceFallbackFactory();
    }

}
