package com.andy.zju.CombinationSums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    private static Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.isEmpty()) return res;

        dfs(digits, 0, new StringBuilder());
        return res;
    }

    private void dfs(String digits, int i, StringBuilder sb) {
        if(i == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String str = map.get(digits.charAt(i));
        for( char c : str.toCharArray()) {
            sb.append(c);
            dfs(digits, i+1, sb);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
