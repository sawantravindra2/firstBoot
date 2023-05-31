package com.ravi.async;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {


    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);


    @Autowired
    GitHubLookupService gitHubLookupService;


    @GetMapping(value = "/welcome")
    public CompletableFuture<List<User>> welcome() throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();


        CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");

        // Wait until they are all done

        List<CompletableFuture<User>> completableFutures = Arrays.asList(page1, page2, page3);

        CompletableFuture<Void> resultantCf = CompletableFuture.allOf(
                completableFutures.toArray(new CompletableFuture[completableFutures.size()]));

        CompletableFuture<List<User>> allFutureResults = resultantCf.thenApply(
                t -> completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList()));


        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());


        return allFutureResults;
    }


}
