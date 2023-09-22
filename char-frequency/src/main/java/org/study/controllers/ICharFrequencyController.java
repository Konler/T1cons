package org.study.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

public interface ICharFrequencyController {

    @PostMapping("/api/frequency")
    @ResponseStatus(HttpStatus.OK)
    Map<Character, Integer> calculateFrequency(@RequestBody String input);

}
