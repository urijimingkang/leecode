package com.andy.cow.subset;

import java.util.*;

public class SumSubSetNoRepeat40 {

    public static void main(String[] ss){
        int[] test=new int[]{10,1,2,7,6,1,5};
        int target=8;
      //  int[] test=new int[]{4,4,2,1,4,2,2,1,3};
      //  int target=6;

        List<List<Integer>>res=new ArrayList<>();
Arrays.sort(test);
        sumsubset(res,test,new ArrayList<>(),0,target);
        System.out.println(res);


    }

    public  static void sumsubset(List<List<Integer>>res,int[] ast,List<Integer> cur, int index,int target) {
      /*  if(ast.length-1==0)
            return;
        if(ast.length-1==1)
        {
            if(ast[1]==target) {
                ArrayList tmp=new ArrayList<Integer>();
                tmp.add(ast[1]);
                res.add(tmp);
            }
            return;

        }
        if(ast.length-1==2)
        {
            if(ast[2]+ast[1]==target) {
                ArrayList tmp=new ArrayList<Integer>();
                tmp.add(ast[1]);
                tmp.add(ast[2]);
                res.add(tmp);
            }
            if(ast[1]==target) {
                ArrayList tmp=new ArrayList<Integer>();
                tmp.add(ast[1]);
                // tmp.add(ast[1]);
                res.add(tmp);
            }
            if(ast[2]==target) {
                ArrayList tmp=new ArrayList<Integer>();
                tmp.add(ast[2]);

                res.add(tmp);
            }
            return;

        }*/
        if(target<0)
            return;
        if(target==0)
        {

            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = index; i <ast.length&& ast[i] <= target ; i++) {
            // ast[i] == ast[i - 1]去除同一层的重复
            //i > index 去除上一层的重复
            if(i > index &&ast[i] == ast[i - 1]) continue;
            cur.add(ast[i]);
            sumsubset(res, ast, cur, i+1, target - ast[i]);
            cur.remove(cur.size() - 1);

        }




    }
}
