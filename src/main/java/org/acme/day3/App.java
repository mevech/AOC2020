package org.acme.day3;

import io.quarkus.runtime.QuarkusApplication;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.List;

@Slf4j
public class App implements QuarkusApplication {
    @Inject
    Utils utils;

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Running day 2");
        log.info("day3 result q1\t{}", utils.countTrees(3 , 1));
        log.info("day2 result q2\t{}", utils.countTreesMultiple(
                List.of(1,3,5,7,1),
                List.of(1,1,1,1,2)
        ));
        return 0;
    }
}
