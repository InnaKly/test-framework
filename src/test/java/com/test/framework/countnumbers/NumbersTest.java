package com.test.framework.countnumbers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.framework.helpers.FileDataHelper.getNumbersFromFile;
import static com.test.framework.helpers.FileDataHelper.getSumFromNumberList;

@Slf4j
public class NumbersTest {

    @Test
    public void countNumbersFromFileTest(){
        double expectedResult = 268.83;
        double actualResult = getSumFromNumberList(getNumbersFromFile("src/main/resources/data/numbers.txt"));
        log.info("Actual sum is: " + actualResult);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
