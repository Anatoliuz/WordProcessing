package com.example.demo.dto;

import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Validated
public class WordDto {

    private Character letter;

    private int count;

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordDto wordDto = (WordDto) o;
        return count == wordDto.count && Objects.equals(letter, wordDto.letter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter, count);
    }

}
