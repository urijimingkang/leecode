package com.andy.com.andy.interview;
import java.util.*;

/**
 * Created by aweng on 7/26/2016.
 */
public class Combination {
    int num;
    public  void Combination(String ss,int num,LinkedList sub){

        if(num==0){
            for(int i=0;i<sub.size();i++){
                System.out.print(sub.get(i)+" ,");
            }
            System.out.println();
            return;
        }
        if(ss==null||ss.length()==0)
            return;
        sub.addLast(ss.charAt(0));
        ss=ss.substring(1);
        Combination(ss,num-1,sub);
        sub.removeLast();
       // sub.removeElement(sub.lastElement());
        Combination(ss,num,sub);
    }
    public  void Combination(String ss)
    {
        int len=ss.length();
        LinkedList subset=new LinkedList();
        for(int i=1;i<=len;i++){
            this.num=i;
            Combination(ss,num,subset);
        }
    }
    public static void main(String[] ss){
        String str="abc";
        Combination c=new Combination();
        c.Combination(str);


    }
}
