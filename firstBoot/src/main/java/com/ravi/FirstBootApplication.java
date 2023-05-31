package com.ravi;

import com.ravi.async.GitHubLookupService;
import com.ravi.async.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;


@SpringBootApplication
@ComponentScan(basePackages = {"com.ravi.*"})
@EnableAsync
public class FirstBootApplication implements CommandLineRunner {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public static void main(String[] args) {
        SpringApplication.run(FirstBootApplication.class, args);

        System.out.println("******** hello welcome with jenkins integration ************** ");

    }


    @Override
    public void run(String... args) throws Exception {
    }


}
