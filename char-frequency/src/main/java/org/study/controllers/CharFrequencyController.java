package org.study.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.study.exceptions.NotValidException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class CharFrequencyController implements ICharFrequencyController {

    @Override
    public Map<Character, Integer> calculateFrequency(String input) {

        final int MAX_INPUT_LENGTH = 10;

        if (input == null) {
            throw new NotValidException("Input string cannot be null");
        }

        if (input.length() > MAX_INPUT_LENGTH) {
            throw new NotValidException("Input string must be less than " + MAX_INPUT_LENGTH + " characters");
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
        }

        return frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
