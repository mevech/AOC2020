package org.acme.day4;


import lombok.extern.slf4j.Slf4j;
import org.acme.InputRetriever.InputRetriever;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class Utils {

    @Inject
    InputRetriever retriever;

    public int mapInput() throws Exception {
        String input = retriever.asOneLine();
        return (int) Arrays.stream(input.split("\n\n"))
                .map(this::createPassword)
                .filter(this::processPassport)
                .count();
    }

    public int validateInput() throws Exception {

        String input = retriever.asOneLine();
        int counter = 0;
        for (String passport : input.split("\n\n")) {
            if (validatePassword(passport)) counter++;
        }
        return counter;
    }

    private Map<String, String> createPassword(String input) {
        String[] pairs = input.replaceAll(" ", "\n").split("\n");
         return Arrays.stream(pairs)
                        .map(pair -> pair.split(":"))
                        .collect(Collectors.toMap(strings -> strings[0], strings -> strings[1]));
    }

    private boolean validatePassword(String input) {
        String[] pairs = input.replaceAll(" ", "\n").split("\n");
        Map<String, Function<String, Boolean>> validateMap = putMethodMap();
        Map<String, String> passport = Arrays.stream(pairs)
                .map(pair -> pair.split(":"))
                .filter(strings -> {
                    if (!validateMap.containsKey(strings[0])) return false;
                    return validateMap.get(strings[0]).apply(strings[1]);
                })
                .collect(Collectors.toMap(strings -> strings[0], strings -> strings[1]));
        return processPassport(passport);
    }

    private boolean processPassport(Map<String, String> passport) {
        return passport.containsKey("byr")
                && passport.containsKey("iyr")
                && passport.containsKey("eyr")
                && passport.containsKey("hgt")
                && passport.containsKey("hcl")
                && passport.containsKey("ecl")
                && passport.containsKey("pid");
    }

    private Map<String, Function<String, Boolean>> putMethodMap() {
        Map<String, Function<String, Boolean>> validator = new HashMap<>();
        validator.put("byr", s -> {
            if (s.length() != 4 ) return false;
            int year = Integer.parseInt(s);
            return year >= 1920 && year <= 2002;
        });
        validator.put("iyr", s -> {
            if (s.length() != 4 ) return false;
            int year = Integer.parseInt(s);
            return year >= 2010 && year <= 2020;
        });
        validator.put("eyr", s -> {
            if (s.length() != 4 ) return false;
            int year = Integer.parseInt(s);
            return year >= 2020 && year <= 2030;
        });
        validator.put("hgt", s -> {
            int height = 0;
            if (s.contains("cm")) {
                height = Integer.parseInt(s.split("cm")[0]);
                return height >= 150 && height <= 193;
            }else if (s.contains("in")){
                height = Integer.parseInt(s.split("in")[0]);
                return height >= 59 && height <= 76;
            }
            return false;
        });
        validator.put("hcl", s-> s.matches("#([0-9]|[a-f]){6}"));
        validator.put("ecl", s-> s.equals("amb") || s.equals("blu")|| s.equals("brn")
                || s.equals("gry")|| s.equals("grn")|| s.equals("hzl")|| s.equals("oth"));
        validator.put("pid", s -> s.matches("[0-9]{9}"));
        validator.put("cid", s -> {return true;});
        return validator;
    }



}
