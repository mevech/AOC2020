package org.acme.day1;

import io.quarkus.runtime.QuarkusApplication;
import lombok.extern.slf4j.Slf4j;
import org.graalvm.collections.Pair;

import javax.inject.Inject;

@Slf4j
public class App implements QuarkusApplication {
    @Inject
    Utils utils;

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Running day 1");
        utils.createHashSet(2020);
        Pair<Integer, Integer> pair = utils.findPairs(2020);
        Pair<Integer, Pair<Integer, Integer>> tripple = utils.findTripple();
        log.info("result {}", pair);
        log.info("result {}", tripple);
        return 0;
    }
}
