package org.acme.day1;

import com.google.common.base.Preconditions;
import io.quarkus.arc.runtime.BeanContainer;
import io.quarkus.runtime.annotations.CommandLineArguments;
import lombok.extern.slf4j.Slf4j;
import org.acme.InputRetriever.FileInputRetriever;
import org.acme.InputRetriever.InputRetriever;
import org.graalvm.collections.Pair;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class Utils {

    @Inject
    InputRetriever inputRetriever;

    int[] intIndexes = new int[2021];

    public void createHashSet(int sum) throws Exception {
        inputRetriever.asList()
                .forEach(n -> {
                            if (Integer.parseInt(n) <= sum)
                                intIndexes[Integer.parseInt(n)] ++;
                });
    }

    public Pair<Integer, Integer> findPairs(int sum) throws Exception {
        for (int i = 0 ; i <= sum; i ++ ){
            if ( intIndexes[sum-i] > 0 && intIndexes[i] > 0) {
                return Pair.create(i, sum-i);
            }
        }
        return null;
    }

    public Pair<Integer, Pair<Integer, Integer>> findTripple() throws Exception {
        for ( int i = 0 ; i <= 2020 ; i ++ ) {
            if (intIndexes[i] > 0 ) {
                Pair<Integer, Integer> pair = findPairs(2020-i);
                if (pair != null)
                return Pair.create(i, findPairs(2020-i));
            }
        }
        return null;
    }


}
