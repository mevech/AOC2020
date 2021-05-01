package org.acme.InputRetriever;

import java.util.List;

public interface InputRetriever {
    public String asOneLine() throws Exception;
    public List<String> asList() throws Exception;

}
