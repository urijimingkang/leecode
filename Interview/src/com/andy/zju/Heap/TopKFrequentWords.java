package com.andy.zju.Heap;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] ss){
    List<String> where = new ArrayList<String>();
        where. add("coding");
        where. add("coding");
    where. add("i");
    where. add("i");
    where. add("love");
    where. add("love");
    where. add("love");

    where. add("very");
        where. add("very");
        where. add("very");
//    List<String> where = new ArrayList<String>();
   where.add("i");
    where.add("i");
//
//// If you need to convert it to a simple array...
//
    String[] words = new String[where.size()];
   where.toArray(words);
       List<String>  res=main(words,2);
        System.out.println(res);
    }


    int k = 2;

    public static List<String> main (String[] words, int k) {



        // if(words == null) {
        //     return Collections.emptyList();
        // }


        Map<String, Integer> map = new HashMap<>();

        for(String word : words) {

            map.compute(word, (key, v) -> v == null? 1 : v+1);
        }

        //Using Method reference
        Queue<String> pq = new PriorityQueue<>(Comparator.<String>comparingInt(map::get).thenComparing(Comparator.reverseOrder())); // turn to a max heap

        for(String word : map.keySet()) {
            pq.offer(word);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        List<String> res = new ArrayList<>();

        while(!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        return res;
    }



}
