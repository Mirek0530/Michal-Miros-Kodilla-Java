package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();
            for (Integer num : numbers) {
                if (num % 2 == 0) {
                    list.add(num);
                }
            }
        return list;
    }
}