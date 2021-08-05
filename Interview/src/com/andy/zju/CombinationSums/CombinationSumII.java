package com.andy.zju.CombinationSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, result, path, 0);
        return result;
    }
    
    public void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> path, int index){
        if(target < 0) return; 
        
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < candidates.length && candidates[i] <= target; i++){
            if(i > index && candidates[i] == candidates[i - 1]) continue;
            // i > index很关键， 确保i为起点的时候不需要跟前面的数字check
            // in other words, 我们已经到了下一层不用跳过
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], result, path,i + 1);
            path.remove(path.size()-1);
        }
    }
}