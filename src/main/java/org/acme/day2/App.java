package org.acme.day2;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import lombok.extern.slf4j.Slf4j;
import org.acme.day1.Utils;
import org.graalvm.collections.Pair;

import javax.inject.Inject;

@Slf4j
public class App implements QuarkusApplication {
    @Inject
    Utils utils;

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Running main2 method");
        utils.createHashSet(2020);
        Pair<Integer, Integer> pair = utils.findPairs(2020);
        Pair<Integer, Pair<Integer, Integer>> tripple = utils.findTripple();
        log.info("result {}", pair);
        log.info("result {}", tripple);
        return 0;
    }
}
