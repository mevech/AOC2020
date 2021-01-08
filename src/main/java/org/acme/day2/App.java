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
        log.info("day2 result q1\t{}", utils.countTrue());
        log.info("day2 result q2\t{}", utils.countTrueNew());
        return 0;
    }
}
