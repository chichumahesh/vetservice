package com.mahesh.application.vetservice;

import com.mahesh.application.vetservice.model.MovieModel;
import com.mahesh.application.vetservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class VetserviceApplication {

   // @Autowired
   // MovieService movieService;

    public static void main(String[] args) {
        SpringApplication.run(VetserviceApplication.class, args);
    }


    @Bean(name = "movieExecutor")
    public Executor getCurrentExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(50);
        executor.setThreadNamePrefix("Async-");
        executor.initialize();
        return executor;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
