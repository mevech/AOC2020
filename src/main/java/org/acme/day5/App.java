package org.acme.day5;

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
        log.info("day5 result q1\t{}", utils.collectSeatId());

        log.info("day5 result q2\2t{}", utils.calSeatId());
        return 0;
    }
}
