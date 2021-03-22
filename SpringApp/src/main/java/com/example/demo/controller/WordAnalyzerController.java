package com.example.demo.controller;

import com.example.demo.dto.WordDto;
import com.example.demo.utils.WordProcessing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("wordanalyzer/analyze")
public class WordAnalyzerController {
    @GetMapping
    public WordDto get(@RequestParam String word){
        WordDto dto = new WordDto();
        Map<Character, Integer> map = WordProcessing.getResult(word);
        if(map.size() != 1){
            throw new RuntimeException("Error in word processing");
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            dto.setLetter(entry.getKey());
            dto.setCount(entry.getValue());
        }
        return dto;
    }
}
