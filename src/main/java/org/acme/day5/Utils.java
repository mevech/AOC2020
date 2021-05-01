package org.acme.day5;

import lombok.extern.slf4j.Slf4j;
import org.acme.InputRetriever.InputRetriever;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class Utils {

    @Inject
    InputRetriever retriever;

    private int calculate(String s) {
        int num = 0;
        char[] chars = s.toCharArray();
        for ( int i = 0 ; i < 10 ; i ++ ){
            int bin = (chars[i] == 'F'||chars[i] == 'L')? 0:1;
            num = (num<<1) + bin;
        }
        return num;
    }

    public Integer collectSeatId() throws Exception {
        List<String> input = retriever.asList();
        return input.stream()
                .map(this::calculate)
                .max(Integer::compareTo).get();
    }

    public int calSeatId() throws Exception {
        List<String> input = retriever.asList();
        boolean[] seats = new boolean[856];
        input.forEach(s -> {
            seats[calculate(s)] = true;
        });
        for (int i = 855; i >= 0 ; i --) {
            if (!seats[i]) return i;
        }
        return 0;
    }

    public String mySeatId() throws Exception {
        char[] seatId = Integer.toBinaryString(calSeatId()).toCharArray();
        for ( int i = 0 ; i < 7; i ++ ) {
            if (seatId[i] == '0') seatId[i] = 'F';
            else seatId[i] = 'B';
        }
        for ( int i = 7 ; i < 10; i ++ ) {
            if (seatId[i] == '0') seatId[i] = 'L';
            else seatId[i] = 'R';
        }
        return String.valueOf(seatId) ;
    }
}
