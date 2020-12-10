package org.acme.InputRetriever;

import io.quarkus.runtime.annotations.CommandLineArguments;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@ApplicationScoped
@Slf4j
public class FileInputRetriever implements InputRetriever {
    @Inject
    @CommandLineArguments
    String[] args;

//    public void printArgs() {
//        log.info("args {}", args[0]);
//    }
    @Override
    public String asOneLine() throws IOException {
        Path filePath= Paths.get(args[0]);
        return new String(Files.readAllBytes(filePath));
    }

    @Override
    public List<String> asList() throws IOException {
        Path filePath= Paths.get(args[0]);
        List<String> inputStrings = Files.readAllLines(filePath);
        return inputStrings;
    }
}
