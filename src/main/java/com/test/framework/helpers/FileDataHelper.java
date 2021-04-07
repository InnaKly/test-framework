package com.test.framework.helpers;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileDataHelper {

    @SneakyThrows
    public static List<Double> getNumbersFromFile(String filePath){
        return Files.lines(Paths.get(filePath))
                .filter(i -> !i.startsWith("#"))
                .filter(l -> !l.isEmpty())
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    public static double getSumFromNumberList(List<Double> numberList){
        return numberList.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
