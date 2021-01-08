package org.acme.day2;

import io.quarkus.runtime.QuarkusApplication;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

@Slf4j
public class App implements QuarkusApplication {
    @Inject
    Utils utils;

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Running day 2");

        return 0;
    }
}
