package org.acme.day2;

import lombok.extern.slf4j.Slf4j;
import org.acme.InputRetriever.InputRetriever;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
@Slf4j
public class Utils {
    @Inject
    InputRetriever retriever;

    public int countTrue() throws Exception {
        List<String> inputs = retriever.asList();
        int counter = 0;
        for( String input : inputs) {
            Expression expression = new Expression(input);

            if (expression.isValid()) {
                counter ++ ;
                log.info("valid expression {}", expression);
                continue;
            }
            log.info("invalid expression {}", expression);
        }
        return counter;
    }

    public int countTrueNew() throws Exception {
        List<String> inputs = retriever.asList();
        int counter = 0;
        for( String input : inputs) {
            Expression expression = new Expression(input);

            if (expression.isValidNew()) {
                counter ++ ;
                log.info("valid expression {}", expression);
                continue;
            }
            log.info("invalid expression {}", expression);
        }
        return counter;
    }
}
