package org.acme.day3;

import lombok.extern.slf4j.Slf4j;
import org.acme.InputRetriever.InputRetriever;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class Utils {

    @Inject
    InputRetriever retriever;

    public long countTreesMultiple(List<Integer> rights, List<Integer> downs) throws Exception {
        long init = 1;
        for ( int i = 0 ; i < rights.size() ; i ++ ) {
            init = init * (long) countTrees(rights.get(i), downs.get(i));
//            log.info("slope {}:{} encounters {} trees", rights.get(i), downs.get(i), countTrees(rights.get(i), downs.get(i)));
        }
        return init;
    }

    public int countTrees(int right, int down) throws Exception {
        final int MAP_ROW;
        final int MAP_COLUMN;
        final List<List<Character>> MAP = createMap();
        MAP_ROW = MAP.size();
        MAP_COLUMN = MAP.get(0).size();
        int counter = 0;
        int column = 0;
        for (int row = 0 ; row < MAP_ROW; row +=down ) {
            if ( MAP.get(row).get(column)=='#' ) counter ++ ;
            column = (column + right) % MAP_COLUMN;
//            log.info("slope \t{}\t:\t{}", row, column);
        }
        return counter;
    }

    public List<List<Character>> createMap() throws Exception {
        List<String> input = retriever.asList();
        return input.stream()
                .map( s -> s.chars()
                        .mapToObj(e->(char)e)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
