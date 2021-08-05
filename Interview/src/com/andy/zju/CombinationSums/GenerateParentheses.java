package com.andy.zju.CombinationSums;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(res, "", 0, 0, n);
        return res;
    }

    private void dfs(List<String> res, String sb, int open, int close, int max) {
        if(sb.length() == max*2) {
            res.add(sb);
            return;
        }

        if(open < max) {
            dfs(res, sb + "(", open+1, close, max);
        }

        if(close < open) {
            dfs(res, sb + ")", open, close+1, max);
        }
    }
}
