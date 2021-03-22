package com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String word = br.readLine();
            System.out.println(getResult(word).toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Возвращает букву с наибольшим числом вхождений и количеством вхождений
    public static Map<Character, Integer> getResult(String word) {
        Map<Character, Integer> res = new HashMap<>();
        int[] numberOfIns = new int[word.length()];

        for (int i = 0; i < word.length(); ++i) {
            char characterToCount = word.charAt(i);
            for (int j = 0; j < word.length(); ++j) {
                char curCharacter = word.charAt(j);
                if (characterToCount == curCharacter) {
                    ++numberOfIns[i];
                }
            }
        }

        int max = findMaxIndex(numberOfIns);
        res.put(word.charAt(max), numberOfIns[max]);
        return res;
    }

    public static int findMaxIndex(int[] numberOfIns) {
        int maxIndex = 0;
        for (int i = 0; i < numberOfIns.length; ++i) {
            if (numberOfIns[i] >= numberOfIns[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
