package org.acme.InputRetriever;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class FileInputRetriever implements InputRetriever {

    @ConfigProperty(name= "input.filepath")
    String inputPath;

    @Override
    public String asOneLine() throws Exception {
        InputStream input = getClass().getClassLoader().getResourceAsStream(inputPath);
        return new String(input.readAllBytes());
    }

    @Override
    public List<String> asList() throws Exception {
        InputStream input = getClass().getClassLoader().getResourceAsStream(inputPath);
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        return br.lines().collect(Collectors.toList());
    }
}
