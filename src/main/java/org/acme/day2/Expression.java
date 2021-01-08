package org.acme.day2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Expression{
    int begin;
    int end;
    char target;
    String sample;

    public Expression(String input) {
        String[] strings0 = input.split("-");
        begin = Integer.parseInt(strings0[0]);
        String[] strings1 = strings0[1].split(" ",2);
        end = Integer.parseInt(strings1[0]);
        String[] strings2 = strings1[1].split(":");
        target = strings2[0].charAt(0);
        sample = strings2[1].trim();
    }

    public String toString() {
        return "\tbegin\t" + begin
                + "\tend\t" + end
                + "\ttarget\t" + target
                + "\tsample\t" + sample;
    }

    public boolean isValid() {
        int count = 0;
        for (char c : sample.toCharArray()) {
            if (c == target) {
                count ++;
            }
        }

        if (count>=begin && count <=end) return true;
        else return false;
    }

    public boolean isValidNew() {
        return sample.charAt(begin-1)==target ^ sample.charAt(end-1)==target;
    }
}
