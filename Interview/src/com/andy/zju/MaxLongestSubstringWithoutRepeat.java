package com.andy.zju;

import java.util.HashMap;

public class MaxLongestSubstringWithoutRepeat {
    public static void main(String[]ss){
        System.out.print(maxLongestSubstringWithoutRepeat("abba"));
    }
    static int maxLongestSubstringWithoutRepeat(String ss){
        int ret=0;
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for (int i = 0,j=0; i <ss.length() ; i++) {
            if(hashMap.containsKey(ss.charAt(i)))
            {
                //hashMap.remove(ss.charAt(j++));
                j=Math.max(hashMap.get(ss.charAt(i)),j);

            }
                hashMap.put(ss.charAt(i),i+1);
                ret=Math.max(ret,i-j+1);


        }
        return ret;
    }
}
