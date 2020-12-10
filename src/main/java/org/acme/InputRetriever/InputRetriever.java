package org.acme.InputRetriever;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

//@ApplicationScoped
public interface InputRetriever {
    public String asOneLine() throws Exception;
    public List<String> asList() throws Exception;

//    void printArgs();
}
