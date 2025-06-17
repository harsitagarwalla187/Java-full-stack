package com.myapp.utility;

import java.util.ArrayList;
import java.util.Arrays;

public class lambda {

    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>(Arrays.asList("Harsit", "ENG", "TECH MAHINDRA"));

        strings.stream().map(string -> string.toLowerCase()).forEach(e -> System.out.println(e));

    }
}
